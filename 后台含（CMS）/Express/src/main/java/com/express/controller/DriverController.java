package com.express.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.express.bean.common.ResultData;
import com.express.common.controller.BaseController;
import com.express.entity.Driver;
import com.express.entity.Truck;
import com.express.mapper.DriverMapper;
import com.express.mapper.TruckMapper;

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
@RequestMapping("/driver")
public class DriverController extends BaseController {
	@Autowired
	private DriverMapper mapper;
	
	@ApiOperation("添加司机接口")
	@PostMapping("insert.action")
	public ResultData insert( Driver driver) {
		info("添加司机"+driver);
		int row = mapper.insert(driver);
		return quickReturn(row);
	}
     
	@ApiOperation("删除司机接口")
	@PostMapping("delete.action")
	public ResultData  deleteById(int id) {
		int row = mapper.deleteById(id);
		return quickReturn(row);
	}
	 
	@ApiOperation("查找司机接口")
	@GetMapping("get.action")
	public ResultData getById(Driver driver) {
		return ResultData.success().setData(mapper.get(driver));
	}
	 
	@ApiOperation("查找所有司机接口")
	@GetMapping("getall.action")
	public ResultData getAll(  ) {
		return ResultData.success().setData(mapper.getAll());
	} 
}
