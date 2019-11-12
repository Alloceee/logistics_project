package com.express.entity.ext;

import java.io.Serializable;

import com.express.entity.Deliverrecord;
 

public class DeliverrecordVO extends Deliverrecord implements Serializable{
  //1个发货单。
  //1个路线。
  //1个司机。
  //1个辆车。
	private String route_name;
	private String driver_name;
	private String truck_name;
	private String truck_num;
	public String getRoute_name() {
		return route_name;
	}
	public void setRoute_name(String route_name) {
		this.route_name = route_name;
	}
	public String getDriver_name() {
		return driver_name;
	}
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	public String getTruck_name() {
		return truck_name;
	}
	public void setTruck_name(String truck_name) {
		this.truck_name = truck_name;
	}
	public String getTruck_num() {
		return truck_num;
	}
	public void setTruck_num(String truck_num) {
		this.truck_num = truck_num;
	}
	@Override
	public String toString() {
		return "DeliverrecordVO [route_name=" + route_name + ", driver_name=" + driver_name + ", truck_name="
				+ truck_name + ", truck_num=" + truck_num + "]";
	}
	
	
	
	
}
