var util=require('util.js');
Page({

  data: {

    swiperHeight:0,
    height:0,
    imgUrls: [
      "../../images/index/banner1.png",
      "../../images/index/banner2.png",
    ],
    indicatorDots: true,
    autoplay: true,
    interval: 5000,
    duration: 1000
  },

  hubing:function(e){
    var height = util.ImageUtil(e);
    this.setData({
      height:height.height,
      swiperHeight: height.swiperHeight
    })
  },
  jump: function (e) {
    var url = e.currentTarget.dataset.jump;
    wx.navigateTo({
      url: '../' + url + "/" + url,
      complete: function () {
        console.log('success')
      }
    });
  },
  scanMailBoxCode(){
    wx.scanCode({
      success: (res) => {
        //校验其合法性。
        let box_id = res.result;
        console.log("box_id", box_id);
        wx.setStorageSync("box_id", box_id);
         wx.switchTab({
           url: '../send/send',
         })
      }
    })
  }

})  