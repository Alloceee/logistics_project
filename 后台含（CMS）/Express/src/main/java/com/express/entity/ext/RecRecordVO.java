package com.express.entity.ext;

import com.express.entity.RecRecord;

import io.swagger.annotations.ApiModel;

@ApiModel("签收记录对象")
public class RecRecordVO extends RecRecord{
	private String site_name;//上次签收的站点名称。
	private String worker_name;//上次签收的员工名称。
	public String getSite_name() {
		return site_name;
	}
	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}
	public String getWorker_name() {
		return worker_name;
	}
	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}
	@Override
	public String toString() {
		return "RecRecordVO [site_name=" + site_name + ", worker_name=" + worker_name + ", getDeliver_id()="
				+ getDeliver_id() + ", getSite_id()=" + getSite_id() + ", getWorker_id()=" + getWorker_id()
				+ ", getCreationtime()=" + getCreationtime() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
