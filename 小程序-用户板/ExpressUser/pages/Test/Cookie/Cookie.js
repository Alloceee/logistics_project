// pages/Test/Cookie/Cookie.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  getCookieData(e){
   wx.$request({
      url: 'http://localhost/user/getdata.action',
      success(res) {
        
      },
     complete(){
       console.info(arguments);
     }
    })

  },
  formSubmit: function (e) {
    let str = e.detail.value.input;
    wx.$request({
      method:"POST",
      url: 'http://localhost/user/setdata.action',
      data:{
        data:str
      },
      success( res ){
        console.info( res );
      }
    })
  },
  formReset: function () {
    console.log('form发生了reset事件')
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

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

  }
})