package com.express.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.express.bean.common.ResultData;
import com.express.common.controller.BaseController;
import com.express.entity.User;
import com.express.mapper.UserMapper;

 
@RestController
@RequestMapping("wxuc")
public class WXUserController extends BaseController {
	@Value("${wx.appid}")
	private String appid;
	@Value("${wx.secret}")
	private String secret;
	
	@Autowired
	private UserMapper mapper;
	 
	@GetMapping("logout.action")
	public void logout(HttpServletRequest rq ) {
		HttpSession ss = rq.getSession(false);
		if(ss != null) {
			ss.invalidate();
			info("正在为您注销！");
		}else {
			info("您未登陆，无需注销");
		}
	}
	
	
	/**
	  * 后台登陆。
	 * @param code
	 * @return
	 */
	@GetMapping("getuserinfo.action")
	public Map<String,String> getUserInfo1( String code ,HttpServletRequest rq ) {
		String js_code = code;
		String grant_type = "authorization_code";
		String url = getRequestURL(appid, secret, js_code, grant_type);
		String response = sendRequestAndGetResponse(url);
		Result1 result1 = JSONObject.parseObject(response, Result1.class);
		Map<String,String> map = new HashMap<String,String>();
		int rs_code  = result1.getErrcode();
		String rs_openid = result1.getOpenid();
		map.put("openid",rs_openid);
		map.put("errcode", rs_code+"");
		
		if( rs_code ==0) {
			error("登陆成功");
			User user = mapper.getByOpenId(rs_openid);
			if(user == null ) {
				info("第一次添加用户");
				User inserruser  = new User();
				inserruser.setOpenid(rs_openid);
				mapper.insert(inserruser);
			}
			rq.getSession().setAttribute("openid", rs_openid);
		}else {
			error("登陆失败");
		}
		return map ;
	}
	
	@PostMapping("updateinfo.action")
	public ResultData updateUserInfo(@RequestBody User user,HttpSession ss) {
		if(ss.getAttribute("openid") != null ) {
			info("用户信息："+user);
			 int row = mapper.updateInfo(user);
			 return quickReturn(row);
		}else {
			error("后台Session已过期");
			return ResultData.fail("登陆信息已过期。请重新刷新页面");
		} 
	}
	


	/**
	 * 获取unionid
	 * @return
	 */
	/*
	@RequestMapping("getinfo2.action")
	@ResponseBody
	public Map<String,String> getUserInfo2(String rawData,String signature,String encryptedData, String iv ) {
		System.out.println("获取解密信息。。。。session_key=："+result1.getSession_key());
		String rs = AECUtils.decrypt(iv, result1.getSession_key(), encryptedData);
		System.out.println("解密信息为：");
		System.out.println(rs);
		Map<String,String> map = new HashMap<String,String>();
		map.put("secret", rs);
		return map ;
	}
	 */
	public static String getRequestURL(String appid,	String secret ,String js_code,String grant_type) {
		StringBuilder url = new StringBuilder();
		url.append("https://api.weixin.qq.com/sns/jscode2session?") 
		   .append("appid=").append(appid).append("&")
		   .append("secret=").append(secret).append("&")
		   .append("js_code=").append(js_code).append("&")
		   .append("grant_type=").append(grant_type);
		return url.toString();
	}
	
	private static String sendRequestAndGetResponse(String url_str) {
		try {
			//1发送请求。
			URL url = new URL(url_str);
			HttpURLConnection urlconn = (HttpURLConnection) url.openConnection();
			urlconn.setRequestMethod("GET");
			urlconn.setInstanceFollowRedirects(false); 
			
			
			
			//2 获取响应。
			urlconn.setDoInput(true);
			ByteArrayOutputStream bout = new ByteArrayOutputStream(urlconn.getContentLength());
			InputStream in = urlconn.getInputStream();
			byte [] buf  = new byte[500];
			while(true) {
				int lenth = in.read(buf);
				if(lenth <=0 )break;
				bout.write(buf, 0, lenth);
			}
			String json_str = new String(bout.toByteArray(),"UTF-8");
			return json_str;
		} catch ( Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static class Result1{
		private String openid;
		private String session_key;
		private String unionid;
		private int errcode;
		private String errmsg;
		public String getOpenid() {
			return openid;
		}
		public void setOpenid(String openid) {
			this.openid = openid;
		}
		public String getSession_key() {
			return session_key;
		}
		public void setSession_key(String session_key) {
			this.session_key = session_key;
		}
		public String getUnionid() {
			return unionid;
		}
		public void setUnionid(String unionid) {
			this.unionid = unionid;
		}
		public int getErrcode() {
			return errcode;
		}
		public void setErrcode(int errcode) {
			this.errcode = errcode;
		}
		public String getErrmsg() {
			return errmsg;
		}
		public void setErrmsg(String errmsg) {
			this.errmsg = errmsg;
		}
		@Override
		public String toString() {
			return "Result1 [openid=" + openid + ", session_key=" + session_key + ", unionid=" + unionid + ", errcode="
					+ errcode + ", errmsg=" + errmsg + "]";
		}
	 
	}
	
}
