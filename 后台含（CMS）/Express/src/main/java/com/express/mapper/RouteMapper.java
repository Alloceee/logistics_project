package com.express.mapper;

import com.express.entity.Route;
import com.express.entity.RouteSite;
import com.express.entity.ext.RouteVO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
@Mapper
public interface RouteMapper extends BaseMapper<Route> {
	/**
	 * 添加主记录。
	 * 要求生成主键返回， 
	 * @param route
	 * @return
	 */
     int insertRoute(Route route);
     
     int deleteRouteById(int id);
     /**
           * 添加子记录
      * @param routesite
      * @return
      */
     int insertRouteSite(RouteSite routesite);
     
     int deleteRouteSiteByRouteId(int routeid);
     
     List<RouteVO> getAllDetail();
     
     
     List<RouteVO> getById(int id);
}
