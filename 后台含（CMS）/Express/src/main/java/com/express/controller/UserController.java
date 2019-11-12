package com.express.controller;


import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.express.bean.common.ResultData;
import com.express.common.controller.BaseController;

import io.swagger.annotations.Api;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
@RestController
@RequestMapping("/user")
@Api("用户接口")
public class UserController extends BaseController{

	@PostMapping("setdata.action")
	public ResultData setData(HttpSession ss,@RequestBody String data) {
		info( "数据 =  "+ data);
		ss.setAttribute("data", data);
		return ResultData.success();
	}
	
	@GetMapping("getdata.action")
	public ResultData getData(HttpSession ss) {
		info(  ss.getAttribute("data") +"" );
		return ResultData.success();
	}
}
