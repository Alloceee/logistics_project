package com.express.entity.ext;

import com.express.entity.Orderstatus;

import io.swagger.annotations.ApiModel;
@ApiModel("订单状态列表。也就是描述了订单到哪里的一堆列表。")
public class OrderstatusVO extends Orderstatus  {
	private String site_name;

	public String getSite_name() {
		return site_name;
	}

	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}

	@Override
	public String toString() {
		return "OrderstatusVO [site_name=" + site_name + ", getId()=" + getId() + ", getOrder_id()=" + getOrder_id()
				+ ", getSite_id()=" + getSite_id() + ", getStatus_desc()=" + getStatus_desc() + ", getCreationtime()="
				+ getCreationtime() + "]";
	}
	
}
