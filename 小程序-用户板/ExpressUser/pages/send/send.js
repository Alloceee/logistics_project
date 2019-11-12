//pages/packagePredictTrans/packagePredictTrans.js
var app=getApp();
var utils = require("../../utils/util.js");
Page({
  /** 
   * 页面的初始数据
   */
  data: {
    selectIndex:0,
    box_id:null,
    addressList: [] 
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function ( ) {
    this.getSiteList();
    //检测一下。
    let openid = wx.getStorageSync("openid");
    if (!openid){
        wx.showModal({
          title: '提示',
          content: '系统检测到您未授权。请先授权登陆',
        });
    }
  },
  /**
   * 获取站点列表。
   */
  getSiteList(){
    let _this = this;
      wx.$request({
        url: wx.$server +'/site/getall.action',
        success(res){
           let data = res.data.data;
          _this.setData({
             addressList: data
           });
        }
      })
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
    //获取扫码页面传过来的邮筒id
    let box_id = wx.getStorageSync("box_id");
    this.setData({
      box_id: box_id
    });
    //移除
    wx.removeStorageSync('box_id')
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
  bindDepotChange: function (e) {
    this.setData({
      selectIndex: e.detail.value
    })
  }, 
  formSubmit:function(e){
    let param = e.detail.value;
    param.send_site_id = this.data.addressList[this.data.selectIndex].id;
    param.box_id = this.data.box_id;
    console.info(param);
    if (!param.send_addr_detail){
      wx.showToast({
        icon:"none",
        title: '请填写详细地址',
      })
      return;
    } 

    if (!param.send_username) {
      wx.showToast({
        icon: "none",
        title: '请填写发件人',
      })
      return;
    }

    if (!param.send_tel) {
      wx.showToast({
        icon: "none",
        title: '请填写联系方式',
      })
      return;
    }
 
    let urlParam = utils.toQueryString(param);
    //不用navigateTo,原因是 navigateTo可以返回。返回时，mailBoxId已经被清空。So...
    wx.redirectTo({
        url: '../send2/send2'.concat("?").concat(urlParam),
    });
  }
})
/**
 快速测试数据：
东莞物流园旁边的小路
张三
15814234184


 * 
 * 
 */