package com.express.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.express.bean.common.ResultData;
import com.express.common.controller.BaseController;
import com.express.entity.Site;
import com.express.entity.Site;
import com.express.mapper.SiteMapper;

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
@RequestMapping("/site")
@Api("站点统一接口")
public class SiteController extends BaseController {
	
	@Autowired
	private SiteMapper mper;
	
	@ApiOperation(value = "添加一个站点")
	@PostMapping("insert.action")
	public ResultData insert( Site add) {
 		info("保存参数："+add);
 		int num = mper.insert(add);
 		info("主键："+add.getId());
 		if( num > 0 ) {
 			return ResultData.success();
 		}else {
 			return ResultData.fail("添加失败");
 		}
 	}
 	
 	@ApiOperation(value = "查询所有站点")
	@GetMapping("getall.action")
	public ResultData getall( ) {
 		List<Site> list = mper.getAll();
 		return ResultData.success().setData( list );
 	}
 	
	@ApiOperation(value = "查询一个站点")
	@GetMapping("byid.action")
	public ResultData getById(Integer id ) {
		Site addr = mper.byId(id);
 		return ResultData.success().setData( addr );
 	}
	
	@ApiOperation(value = "删除一个站点")
	@PostMapping("deletebyid.action")
	public ResultData deleteById(Integer id ) {
		int row = mper.deleteById(id);
		if( row > 0 ) {
 			return ResultData.success();
 		}else {
 			return ResultData.fail("删除失败");
 		}
 	}
	
	
	
}
