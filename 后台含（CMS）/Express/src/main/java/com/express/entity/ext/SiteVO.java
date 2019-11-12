package com.express.entity.ext;

import com.express.entity.Address;
import com.express.entity.Site;

import io.swagger.annotations.Api;

@Api("站点包装对象")
public class SiteVO extends Site{
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
