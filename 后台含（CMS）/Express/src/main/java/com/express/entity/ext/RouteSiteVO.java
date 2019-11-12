package com.express.entity.ext;

import com.express.entity.RouteSite;

import io.swagger.annotations.ApiModel;

@ApiModel(value="路线站点包装类", description="")
public class RouteSiteVO extends RouteSite{
	 private SiteVO site;

	public SiteVO getSite() {
		return site;
	}

	public void setSite(SiteVO site) {
		this.site = site;
	}
	 
}
