// pages/packagePredictTrans/packagePredictTrans.js
var app = getApp();
var utils = require("../../utils/util.js");
Page({

  /**
   * 页面的初始数据
   */
  data: {
    selectIndex:0,
    sendInfo:null,
    addressList: [] 
  },
  bindDepotChange: function (e) {
    this.setData({
      selectIndex: e.detail.value
    })
  }, 
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (queryString) {
    this.data.sendInfo = queryString;
    this.getSiteList();
  },
  /**
   * 获取站点列表。
   */
  getSiteList() {
    let _this = this;
    wx.$request({
      url: wx.$server + '/site/getall.action',
      success(res) {
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
  toLastStep(){  
    wx.switchTab({
      url: '../send/send'
    })
  },

  formSubmit: function (e) { 
    let param = e.detail.value;
    param.rec_site_id = this.data.addressList[this.data.selectIndex].id;
   
    param = Object.assign(param, this.data.sendInfo);
    console.info(param );
     
    if (!param.rec_addr_detail) {
      wx.showToast({
        icon: "none",
        title: '请填写详细地址',
      })
      return;
    }

    if (!param.rec_username) {
      wx.showToast({
        icon: "none",
        title: '请填写发件人',
      })
      return;
    }

    if (!param.rec_tel) {
      wx.showToast({
        icon: "none",
        title: '请填写联系方式',
      })
      return;
    }

    let openid = wx.getStorageSync("openid");
    if (!openid) {
      wx.showModal({
        title: '提示',
        content: '系统检测到您未授权。请先授权登陆',
      });
      return;
    }
    //带上openid
    param.openid = openid;

    wx.$request({
      url: wx.$server + '/order/insert.action',
      method:"POST",
      data: param,
      success(res){
        if (res.data.code ==0 ){
            wx.redirectTo({
              url: '../success/success',
            })
        }else{
          wx.showModal({
            title: '错误提示',
            content: res.data.error,
          })
        }
      }
    });

/*
  
 */
  }
})


/**
 快速测试数据：
钦州物流园旁边的十字路口
李四
1872041186


 * 
 * 
 */