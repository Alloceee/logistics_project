const app = getApp();
Page({
  data:{
    userinfo:null
  },
   onShow(){
     var userinfo = wx.getStorageSync('userinfo');
     console.info(userinfo);
     this.setData({
       userinfo: userinfo
     });  
  },
  login(e){
    let param = e.detail.value;
    if (!param.id){
      wx.showToast({
        icon:"none",
        title: '请填写工号',
      })
      return;
    }

    if (!param.password) {
      wx.showToast({
        icon: "none",
        title: '请填写密码',
      })
      return;
    } 
      wx.$request({
        url: wx.$server +"/worker/login.action",
        method:"GET",
        data: param,
        success(res){
          let rs = res.data;
          console.info(res);
          if(rs.code == 0){
       
            wx.setStorage({
              key: 'userinfo',
              data: rs.data,
            });
          
            wx.showToast({
              icon: "none",
              title: ""+rs.success,
            });
            wx.switchTab({
              url: '../index/index',
            })
          }else{
            wx.showToast({
              icon:"none",
              title: ""+rs.error,
            })
          }
        }
      });
  },
  logout(){
     //1 清空缓存
     wx.removeStorage({
       key:"userinfo"
    });
    //2 页面数据还原
    this.setData({
      userinfo:null
    });
    //3后台注销
    wx.$request({
      url: wx.$server + "/worker/logout.action"
    });
  }
})