package com.express.entity;

import java.io.Serializable;
 
import io.swagger.annotations.ApiModel;
@ApiModel("签收记录对象")
public class RecRecord implements Serializable {
	private Integer deliver_id;
	private Integer site_id;
	private Integer worker_id;
	private String creationtime;
	public Integer getDeliver_id() {
		return deliver_id;
	}
	public void setDeliver_id(Integer deliver_id) {
		this.deliver_id = deliver_id;
	}
	public Integer getSite_id() {
		return site_id;
	}
	public void setSite_id(Integer site_id) {
		this.site_id = site_id;
	}
	public Integer getWorker_id() {
		return worker_id;
	}
	public void setWorker_id(Integer worker_id) {
		this.worker_id = worker_id;
	}
	public String getCreationtime() {
		return creationtime;
	}
	public void setCreationtime(String creationtime) {
		this.creationtime = creationtime;
	}
	@Override
	public String toString() {
		return "RecRecord [deliver_id=" + deliver_id + ", site_id=" + site_id + ", worker_id=" + worker_id
				+ ", creationtime=" + creationtime + "]";
	}
	
}
