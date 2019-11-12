package com.express.entity.ext;

import java.io.Serializable;

import com.express.entity.Order;
import com.express.entity.Orderstatus;

import io.swagger.annotations.ApiModel;
@ApiModel("订单更新对象。两个表一起更新。订单表是update操作，订单状态表是insert操作")
public class UpdateOrder implements Serializable {
	
    private  Order order;
    private Orderstatus orderstatus;
    
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Orderstatus getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(Orderstatus orderstatus) {
		this.orderstatus = orderstatus;
	}
	
	@Override
	public String toString() {
		return "UpdateOrder [order=" + order + ", orderstatus=" + orderstatus + "]";
	}
    
	
    
}
