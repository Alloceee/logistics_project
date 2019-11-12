package com.express.entity.ext;

import java.io.Serializable;
import java.util.Arrays;

import com.express.entity.Order;
import com.express.entity.Orderstatus;

import io.swagger.annotations.ApiModel;

@ApiModel("更新订单状态对象。用于接收来自于前端的请求数据。")
public class UpdateOrderList implements Serializable {
	private int [] ids;
	private Orderstatus orderstatus;
	private int status;
	
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	public Orderstatus getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(Orderstatus orderstatus) {
		this.orderstatus = orderstatus;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UpdateOrderList [ids=" + Arrays.toString(ids) + ", orderstatus=" + orderstatus + ", status=" + status
				+ "]";
	}
	 
}	
