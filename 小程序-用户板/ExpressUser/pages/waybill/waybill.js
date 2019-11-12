// waybill.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    listData: [ ]
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
  
  },
    // 查询按钮
  formSubmit:function(e){
      var key = e.detail.value.number;
      let map={
        123456: [{ "time": "2017-07-10 10:22:32", "place": "钦州" }, 
                 { "time": "2017-07-11 16:32:42", "place": "南宁" },
                 { "time": "2017-07-12 19:12:26", "place": "桂林" }],

        456789: [{ "time": "2017-07-16 16:33:42", "place": "南宁" },
                 { "time": "2017-07-17 19:12:26", "place": "桂林" }]
      };
     let list = map[key];
     if(!list){
       list =[];
     }
     this.setData({
       listData: list
     });
  }
  
})