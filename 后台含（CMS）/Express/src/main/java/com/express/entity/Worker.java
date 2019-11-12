package com.express.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
@ApiModel(value="Worker对象", description="")
public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工id")
    private Integer id;

    @JsonIgnore
    private String password;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "话电号码")
    private String tel;

    @ApiModelProperty(value = "所属的站点")
    private Integer site_id;

    @ApiModelProperty(value = "工种类型1 快递员  2 站点售货员 3 站点分拣员")
    private Integer type;

   
    
    
	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getTel() {
		return tel;
	}




	public void setTel(String tel) {
		this.tel = tel;
	}




	public Integer getSite_id() {
		return site_id;
	}




	public void setSite_id(Integer site_id) {
		this.site_id = site_id;
	}




	public Integer getType() {
		return type;
	}




	public void setType(Integer type) {
		this.type = type;
	}




	@Override
	public String toString() {
		return "Worker [id=" + id + ", password=" + password + ", name=" + name + ", tel=" + tel + ", site_id="
				+ site_id + ", type=" + type + "]";
	}

    
}
