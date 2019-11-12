// pages/mailbox/mailbox.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    selectIndex: 0,
    siteList: [{ name: "请选择", id: -1 }, { name: "上海", id: 124 }, { name: "南宁", id: 125 }] 
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
     
  },
  bindListChange(e) {
    let index = e.detail.value;
    this.setData({
      selectIndex: index
    });
    if (index > 0 ){
      let item = this.data.siteList[index];
      this.searchMailBoxByAddressId(item.id);
    }
  },
  searchMailBoxByAddressId(id){
     //1 调用网络请求。
     //2 将查找出的结果，渲染到界面上。
    let datalist = [
      { site_id: 1, addr_id: 123, id: 1003, seq: 1 },
      { site_id: 1, addr_id: 126, id: 1004, seq: 2 },
      { site_id: 1, addr_id: 127, id: 1005, seq: 3 }
    ];

    this.setData({
      maxboxList: datalist
    });
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})