//app.js
wx.$server="http://localhost";
wx.$request = function (option) {
  let _option = option;
  //包装一下。
  let _op={
     complete(res){
       //1判断并解析JSESSIONID
       let jessionid = res.header["Set-Cookie"];
       if (jessionid ){
         let start = jessionid.indexOf("JSESSIONID");
         let end = jessionid.indexOf(";",start);
         jessionid = jessionid.substring(start,end);
         //2 保存JESSIONID
         wx.setStorageSync("JSESSIONID", jessionid);
       }
       //回调。
       if (typeof _option.complete == "function") {
         _option.complete.apply(null, arguments);
       }
     }
  };
  //3 合并参数
  for (var k in option){
    if (k !="complete" ){
      _op[k] = option[k];
    }
  }
  //4取出Cookie加入。
  let jsid = wx.getStorageSync("JSESSIONID");
  if (jsid ){   
    if ( !_op.header ) { 
        //4.1 如果未设置任何请求头。
       _op.header = { "Cookie": jsid };
    } else if (!_op.header.Cookie ){
        //4.2 如果设置请求头，但没有Cookie头。
       _op.header.Cookie = jsid;
    }else{
       //4.3 如果有Cookie请求头。
       //判断是否携带了 JSESSIONID字段，有则修改。无则追加。
      let start = _op.header.Cookie.indexOf("JSESSIONID");
      if (start == -1 ){
        _op.header.Cookie += (";"+jsid);
      }else{
        let end = _op.header.Cookie.indexOf(";", start);
        if(end ==-1){
            //start~ _op.header.Cookie.length 开始替换掉。
          end = _op.header.Cookie.length;
        }else{
            //start~ end 开始替换掉。
        }
        let old_jsid = _op.header.Cookie.substring(start, end);
        _op.header.Cookie = _op.header.Cookie.replace(old_jsid, jsid);
      }
    }
  }
  //5 发出实际请求。
  wx.request(_op);
}
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo
              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })
  },
  globalData: {
    userInfo: null
  }
})