package com.express.bean.common;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="统一响应对象", description="")
public class ResultData implements Serializable{
	
	public static ResultData success() {
		return success("OK");
	}
	
	public static ResultData success(String msg) {
		ResultData rs = new ResultData();
		rs.setCode(0);
		rs.setSuccess(msg);
		return rs;
	}
	
	
	public static ResultData fail() {
		return fail("ERROR");
	}
	
	public static ResultData fail(String msg) {
		ResultData rs = new ResultData();
		rs.setCode(-1);
		rs.setError(msg);
		return rs;
	}
	
	@ApiModelProperty("真实数据")
	private Object data;
	
	@ApiModelProperty("令牌")
	private String token;
	
	@ApiModelProperty("数据总数，用于分页")
	private int total;
	 
	@ApiModelProperty("成功时返回的消息")
	private String success = "OK";
	
	@ApiModelProperty("失败时返回的消息")
	private String error;
	
	
	@ApiModelProperty("请求码：0  成功  -1失败")
	private int code = 0;
	
	@ApiModelProperty("业务状态码： 挺多。")
	private String serviceCode;

	public Object getData() {
		return data;
	}

	public ResultData setData(Object data) {
		this.data = data;
		return this;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	@Override
	public String toString() {
		return "ResultData [data=" + data + ", token=" + token + ", total=" + total + ", success=" + success
				+ ", error=" + error + ", code=" + code + ", serviceCode=" + serviceCode + "]";
	}
	
	
	
	
}
