package com.express.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.express.bean.common.ResultData;
import com.express.common.controller.BaseController;
import com.express.entity.Worker;
import com.express.mapper.WorkerMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
@RestController
@RequestMapping("/worker")
@Api("员工接口：CRUD ")
public class WorkerController extends BaseController {
	
	@Autowired
	private WorkerMapper mapper;
	
	@ApiOperation("添加员工")
	@PostMapping("insert.action")
	public ResultData insert(Worker wk) {
		info("添加数据  "+wk);
		wk.setPassword("123456");//默认密码
		int row = mapper.insert(wk);
		return quickReturn( row );
	}
	
	@ApiOperation("检测登陆")
	@GetMapping("checklogin.action")
	public ResultData checklogin(HttpServletRequest rq) {
		HttpSession ss = rq.getSession(false);
		if(ss == null ) {
			return ResultData.fail("未登录");
		}else {
			return ResultData.success().setData( ss.getAttribute("worker"));
		}
	}
	
	@ApiOperation("获取员工接口")
	@GetMapping("all/{detail}.action")
	public ResultData getAll(@PathVariable("detail") String detail) {
		ResultData m = ResultData.success();
		List<Worker>  list = null;
		if("detail".equals( detail )) {
			list = mapper.getAllDetail();
		}else {
			list = mapper.getAll();
		}
		m.setData( list );
		return m;
	}
	 
	
	@ApiOperation("员工登陆接口")
	@GetMapping("login.action")
	public ResultData login(Worker work,HttpServletRequest rq) {
		Worker wk = mapper.get(work);
		if( wk != null ) {
			rq.getSession().setAttribute("worker", wk);
			wk.setPassword( null );
			return ResultData.success("登陆成功").setData( wk );
		}
		return ResultData.fail("用户名或密码错误");
	}
	
	
	@ApiOperation("员工注销登陆接口")
	@GetMapping("logout.action")
	public ResultData login(HttpServletRequest rq) {
		HttpSession ss = rq.getSession(false);
		if( ss != null ) {
			info("员工："+ss.getAttribute("userinfo")+" 正在注销，sessionid="+ss.getId());
			ss.invalidate();
		}
		return ResultData.success();
	}
	
	
	@ApiOperation("获取员工接口")
	@GetMapping("byId.action")
	public ResultData byId(int id) {
		Worker wk = new Worker();
		wk.setId(id);
		ResultData m = ResultData.success();
		wk = mapper.get(wk);
		wk.setPassword(null);
		m.setData( wk );
		return m;
	}
	
	@ApiOperation("获取员工接口")
	@PostMapping("deletebyid.action")
	public ResultData deleteById(int id) {
		 return quickReturn( mapper.deleteById(id) );
	}
	
}
