const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: null,
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
        if (app.globalData.userInfo) {
          this.setUserInfo(app.globalData.userInfo );
        } else if (this.data.canIUse) {
          // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
          // 所以此处加入 callback 以防止这种情况
          app.userInfoReadyCallback = res => {
            
            this.setUserInfo(res.userInfo);
          }
        } else {
          // 在没有 open-type=getUserInfo 版本的兼容处理
          let _this = this;
          wx.getUserInfo({
            success: res => {
              app.globalData.userInfo = res.userInfo 
              _this.setUserInfo(res.userInfo);
            }
          }) 
        } 
  },
  logout( ){
      //1 请求后台注销。
      wx.$request({
       url: wx.$server +"/wxuc/logout.action"
      }) 
      //2 将当前登陆标志位清空。
        this.setData({
          userInfo: null,
          hasUserInfo: false
        });
  },
  setUserInfo(userInfo){
    console.info(userInfo);
    this.setData({
      userInfo: userInfo,
      hasUserInfo: true
    });
 
    wx.login({
      success(res){
          console.info(res);
          wx.$request({
            url: wx.$server +'/wxuc/getuserinfo.action',
            data:{
              code:res.code
            },  
            success(rs){
              if ( rs.data.openid ){
                  //后台登陆成功。
                updateUserInfo(rs.data.openid);
              }
            }
          })
      }
    }) 
     
    let updateUserInfo=function(openid){
      //1 防重复更新
      let save_openid = wx.getStorageSync("openid");
      if (save_openid){
        console.info("openid已经存在，无需重复更新");
        return;
      } 
      //2准备更新的数据模型。
      let updateModel={
        avatarurl: userInfo.avatarUrl,
        gender: userInfo.gender,
        nickname: userInfo.nickName,
        openid: openid
      };
      //3请求后台更新
      wx.$request({
        method:"POST",
        url: wx.$server +"/wxuc/updateinfo.action",
        data: updateModel,
        success(res){
          if (res.data.code == 0) {
            console.info("缓存openid");
            wx.setStorageSync("openid", openid)
          } 
        }  
      });
      
    }
  },
  setting(){
     wx.navigateTo({
       url: '../setting/setting',
     });
     //请求获取openid
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },  
  /**
   * 用户点击登陆按钮的回调函数。
   */
  getUserInfo(e){
    app.globalData.userInfo = e.detail.userInfo
    this.setUserInfo(e.detail.userInfo );
  },
  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },
  jump: function (e) {
    var url = e.currentTarget.dataset.jump;
    wx.navigateTo({
      url: '../' + url + "/" + url,
      complete: function () {
        console.log('success')
      }
    });
  }
})