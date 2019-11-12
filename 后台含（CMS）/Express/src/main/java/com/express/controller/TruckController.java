package com.express.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.express.bean.common.ResultData;
import com.express.common.controller.BaseController;
import com.express.entity.Truck;
import com.express.mapper.TruckMapper;

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
@RequestMapping("/truck")
@Api("车辆管理接口")
public class TruckController extends BaseController {
	@Autowired
	private TruckMapper mapper;
	
	@ApiOperation("添加车辆接口")
	@PostMapping("insert.action")
	public ResultData insert( Truck truck) {
		info("添加车辆"+truck);
		int row = mapper.insert(truck);
		return quickReturn(row).setData(truck);
	}
     
	@ApiOperation("删除车辆接口")
	@PostMapping("delete.action")
	public ResultData  deleteById(int id) {
		int row = mapper.deleteById(id);
		return quickReturn(row);
	}
	 
	 
	@ApiOperation("查找车辆接口")
	@GetMapping("get.action")
	public ResultData get( Truck truck ) {
		info("查找车辆参数："+truck);
		return ResultData.success().setData(mapper.get( truck ));
	} 
}
