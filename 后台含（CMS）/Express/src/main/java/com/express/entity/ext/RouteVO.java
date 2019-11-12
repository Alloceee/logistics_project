package com.express.entity.ext;

import java.util.List;

import com.express.entity.Route;

import io.swagger.annotations.ApiModel;
@ApiModel(value="路线包装类", description="")
public class RouteVO extends Route{
	private List<RouteSiteVO> routesitelist;

	public List<RouteSiteVO> getRoutesitelist() {
		return routesitelist;
	}

	public void setRoutesitelist(List<RouteSiteVO> routesitelist) {
		this.routesitelist = routesitelist;
	}
	
	
}
