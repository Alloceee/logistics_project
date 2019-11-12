package com.express.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
@ApiModel(value="Mailbox对象", description="")
public class Mailbox implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "邮筒编号")
    private Integer id;

    
    @ApiModelProperty(value = "所属的站点id")
    private Integer site_id;

    @ApiModelProperty(value = "邮筒名称")
    private String name;
    @ApiModelProperty(value = "邮筒所在地址经度")
    private String lng;
    @ApiModelProperty(value = "邮筒所在地址纬度")
    private String lat;
    @ApiModelProperty(value = "创建时间")
    private String creationtime;
    @ApiModelProperty(value = "最后修改时间")
    private String lastupdate;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSite_id() {
		return site_id;
	}

	public void setSite_id(Integer site_id) {
		this.site_id = site_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(String creationtime) {
		this.creationtime = creationtime;
	}

	public String getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
	}

	@Override
	public String toString() {
		return "Mailbox [id=" + id + ", site_id=" + site_id + ", name=" + name + ", lng=" + lng + ", lat=" + lat
				+ ", creationtime=" + creationtime + ", lastupdate=" + lastupdate + "]";
	}

	 
    
     
 
}
