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
import com.express.entity.ext.RouteSiteVO;
import com.express.entity.ext.RouteVO;
import com.express.mapper.RouteMapper;

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
@RequestMapping("/route")
@Api("路线管理类")
public class RouteController extends BaseController {
	@Autowired
	private RouteMapper mapper;
	
	@PostMapping("insert.action")
	public ResultData insert( @RequestBody RouteVO routevo) {
		info( routevo+"" );
		mapper.insertRoute(routevo);
		List<RouteSiteVO> rsite = routevo.getRoutesitelist();
		if(rsite != null && rsite.isEmpty() ==false ) {
			 for(RouteSiteVO r : rsite) {
				  r.setRoute_id( routevo.getId() );
				  mapper.insertRouteSite( r );
			 }
		}
		return ResultData.success();
	}
	
	@ApiOperation("删除一条路线")
	@GetMapping("delete.action")
	public ResultData delete(int id) {
		//1 删主表  id  -- 1条
		mapper.deleteRouteById(id);
		//2 删从表   route_id -- 多条 
		int route_id = id;
		mapper.deleteRouteSiteByRouteId(route_id);
		return null;
	}
	
	@ApiOperation("查询一条路线的详情")
	@GetMapping("byid.action")
	public ResultData byId(int id) {
		info("id="+id);
		return ResultData.success().setData( mapper.getById(id) );
	}
	
	@ApiOperation("查询所有路线的详情")
	@GetMapping("all.action")
	public ResultData getAll( ) {
		return ResultData.success().setData( mapper.getAllDetail() );
	}
}
