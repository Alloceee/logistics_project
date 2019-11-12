package com.express.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.express.bean.common.ResultData;
import com.express.common.controller.BaseController;
import com.express.entity.Orderstatus;
import com.express.mapper.OrderstatusMapper;

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
@RequestMapping("/orderstatus")
@Api("订单状态明细接口")
public class OrderstatusController extends BaseController{
	@Autowired
	private OrderstatusMapper mapper;
	 
	
	@ApiOperation("获取用户的某个订单的详细状态：可传site_id ")
	@GetMapping("get.action")
     public ResultData get(int order_id) {
		   info("获取用户的某个订单的详细状态："+order_id);
		   return ResultData.success().setData(   mapper.get(order_id) );
     }
}
