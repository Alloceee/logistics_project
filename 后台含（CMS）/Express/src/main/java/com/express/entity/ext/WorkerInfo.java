package com.express.entity.ext;

 
import com.express.entity.Site;
import com.express.entity.Worker;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="员工信息对象，包含公司信息", description="")
public class WorkerInfo extends Worker{
	@ApiModelProperty("公司信息")
	private Site site;

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
}
