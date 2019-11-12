package com.express.controller;


import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.express.bean.common.HttpSessionKey;
import com.express.bean.common.ResultData;
import com.express.common.controller.BaseController;
import com.express.entity.Admin;
import com.express.mapper.AdminMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
@RestController
@RequestMapping("/admin")
@Api(value = "管理员接口")
public class AdminController extends BaseController{
	 
	@Autowired
	private AdminMapper adminmaper;
	
	@ApiOperation(value = "管理员登陆接口")
	@PostMapping("login.action")
	public ResultData login( Admin  admin,@ApiIgnore HttpSession ss) {
		info("管理员登陆信息："+admin);
		Admin ad = adminmaper.login(admin);
		if(ad != null ) {
			ss.setAttribute(HttpSessionKey.ADMIN_SESSION.getCode(), ad);
			return ResultData.success("登陆成功");
		}
		return ResultData.fail("用户名或密码错误");
	}
}
