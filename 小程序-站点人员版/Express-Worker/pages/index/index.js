 
const utils =require("../../utils/util.js");
Page({
  data:{
     deliverinfo:null,
     deliverlist:[]
  },   
  checkLogin(){
    var value = wx.getStorageSync('userinfo'); 
    if (!value) {
      wx.switchTab({
        url: '../my/my'
      })
      throw new Error("刹车")
      return;
    }
    //保存用户信息。
    this.data.userinfo = value;
  },
  /**
   * 扫描获取备货单id。
   */
  getDeliverId(){
    this.checkLogin();
    let _this = this;
    wx.scanCode({
      success: (res) => {
        utils.checkNumFormat(res.result);
        getDeliverInfo(res.result);
      }
    })


    //2获取发货单信息。
   let getDeliverInfo=function(id){
     wx.$request({
       url: wx.$server + "/deliverrecord/getdetail.action?id="+id,
       success(res){
         //数字格式验证。
         let datas = res.data.data;
         if(datas && datas.length > 0){
           _this.setData({
             deliverinfo: datas[0]
           });
         }else{
           wx.showToast({ 
             icon:"none",
             title: '发货单不存在',
           })
         }
       }
     });
   }
  },
  /**
   * 扫描物件获取其订单id。
   */
  scanOrderForDeliver(){
    this.checkLogin();
    let _this = this;
    //1 获取备货单
    if (!this.data.deliverinfo){
      wx.showToast({
        icon:"none",
        title: '请先扫描发货单',
      })
       return;
    } 
    
     //2 扫描快件上的二维码。
    wx.scanCode({
      success: (res) => { 
        utils.checkNumFormat(res.result);
        //省略校验合法性的步骤。
        getOrderData({
          deliver_id: _this.data.deliverinfo.id,
          order_id: res.result
        });
     
      }
    })
  
    let getOrderData=function(param){
      wx.request({
        url: wx.$server + '/order/getby.action?id=' + param.order_id,
        success(res){
          let rs = res.data;
          if (rs.code == 0 ){
              //加载出货物了再保存。
            saveRecord(param, rs.data[0]);
          }else{
            wx.showToast({ 
              icon:"none",
              title: rs.error +'该物件未入库',
            })
          }
        }  
      })
    }
     //3 保存。
    let saveRecord=function(bindvo,order){
      //bindvoe ={deliver_id,order_id,site_id,worker_id}
      bindvo.site_id = _this.data.userinfo.site_id;
      bindvo.worker_id = _this.data.userinfo.id;
      wx.$request({  
        url:wx.$server+"/deliverrecord/deliver/bind.action",
        data: bindvo,
        method: "POST",
        success(res){
            let rs = res.data;
            if(rs.code ==-1 ){
              wx.showToast({
                icon:"none",
                title: rs.error +'',
              })
            }else{
              _this.data.deliverlist.push(order);
              _this.setData({
                deliverlist: _this.data.deliverlist
              });
            }
        }
      });
    }
    

  }
})