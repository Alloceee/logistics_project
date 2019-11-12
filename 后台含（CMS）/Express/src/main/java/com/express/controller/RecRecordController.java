package com.express.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.express.bean.common.ResultData;
import com.express.common.controller.BaseController;
import com.express.entity.RecRecord;
import com.express.entity.Worker;
 
import com.express.service.RecRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("recrecord")
@Api("签收接口")
public class RecRecordController  extends BaseController{
	@Autowired
	private RecRecordService service;
	
	@ApiOperation("查询某个发货单的历史签收记录")
	@GetMapping("get.action")
	public ResultData getDetail(int deliver_id) {
		info("发货单id："+deliver_id);
		return service.getDetail(deliver_id);
	}
	
	@ApiOperation("新增签收记录。由于请求方来自于微信小程序。所以用JSON格式传递。")
	@PostMapping("insert.action")
	public ResultData insert(@RequestBody RecRecord record,HttpServletRequest rq) {
		info("用户签收一整车的货物。信息==> "+record);
		HttpSession ss = rq.getSession(false);
		if(ss == null )return ResultData.fail("请先登录");
		Worker wk = (Worker) ss.getAttribute("worker");
		return service.insert(record,wk);
	}	
}
