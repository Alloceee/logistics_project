package com.express.entity.ext;

import java.io.Serializable;

import com.express.entity.Deliverrecorddetail;

import io.swagger.annotations.Api;
@Api
public class BindDeliverVO extends Deliverrecorddetail implements Serializable{
	private int worker_id;
	private int site_id;
	  
	
	public int getSite_id() {
		return site_id;
	}
	public void setSite_id(int site_id) {
		this.site_id = site_id;
	}
	public int getWorker_id() {
		return worker_id;
	}
	public void setWorker_id(int worker_id) {
		this.worker_id = worker_id;
	}
	@Override
	public String toString() {
		return "BindDeliverVO [worker_id=" + worker_id + ", site_id=" + site_id + ", getDeliver_id()=" + getDeliver_id()
				+ ", getOrder_id()=" + getOrder_id() + ", toString()=" + super.toString() + "]";
	}
	
	 
	
}
