const utils =require("../../utils/util.js");
Page({
  data: {
    deliverinfo: null 
  },
  checkLogin() {
    var value = wx.getStorageSync('userinfo');
    if (!value) {
      wx.switchTab({
        url: '../my/my'
      })
      throw new Error("刹车")
    }
    //保存用户信息。
    this.data.userinfo = value;
  },
  /**
   * 扫描获取备货单id。
   */
  getDeliverId() {
    this.checkLogin();
    let _this = this;
    wx.scanCode({
      success: (res) => {
        utils.checkNumFormat(res.result);
        _this.loadDeliverInfo(res.result);
      }
    })  
  },
  /**
   * 获取发货单信息。
   */
  loadDeliverInfo(id){
    let _this = this;
    wx.$request({
      url: wx.$server + "/deliverrecord/getdetail.action?id=" + id,
      success(res) {
        //数字格式验证。
        let datas = res.data.data;
        if (datas && datas.length > 0) {
          _this.setData({
            deliverinfo: datas[0]
          });

          _this.getLastReceiveRecord(datas[0]);
        } else {
          wx.showToast({
            icon: "none",
            title: '发货单不存在',
          })
        }
      }
    });
  },
  reload(){
    this.loadDeliverInfo(this.data.deliverinfo.id);
  },
  receive() {
    let _this = this;
    //console.info(this.data.deliverinfo);
   // console.info(this.data.userinfo);
    //console.info("===========");
    //1 检测登陆
    this.checkLogin();

    //2 判断身份
     if (this.data.userinfo.type !=2){
      wx.showToast({
        icon:"none",
        title: '请用收货员身份登陆',
      })
      return;
    } 

    //3 判断重复签收。
    let user_belong_site_id = this.data.userinfo.site_id;
    let exist = false;
    this.data.recrecordlist.map(function( item ){
      if (item.site_id == user_belong_site_id){
        exist =true;
        return;
      }
    });
    if (exist){
      wx.showToast({
        icon: "none",
        title: '您已签收过。无需重复操作',
      })
      return;
    } 

    //4 开始签收
    let insertmodel={
      deliver_id: this.data.deliverinfo.id,
      site_id: user_belong_site_id,
      worker_id:this.data.userinfo.id
    };
    wx.$request({
      url: wx.$server + "/recrecord/insert.action",
      data: insertmodel,
      method:"POST",
      success(res){
        let  rs = res.data;
        if (rs.code ==0){
          wx.showToast({
            icon:"none",
            title: '签收成功！',
          });
          //重新刷新页面结果。 
          _this.reload();
        }else{  
          wx.showToast({
            icon: "none",
            title: rs.error+'',
          })
        }  
      }
    });
  },
  /**
   * 获取该发货单的历史签收记录。以便查询是否重复签收。
   */
  getLastReceiveRecord(record){
    let _this = this;
    wx.$request({
      url: wx.$server + "/recrecord/get.action?deliver_id=" + record.id,
      success(res){
         let rs = res.data;
         //将历史签收记录渲染到界面上。
         _this.setData({
           recrecordlist: rs.data
         });
      }
    });
  }
  
})