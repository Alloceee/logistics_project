package com.express.entity;
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
@ApiModel(value="Truck对象", description="")
public class Truck implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "车辆编号")
    private Integer id;

    @ApiModelProperty(value = "车辆名称")
    private String name;

    @ApiModelProperty(value = "车牌号")
    private String num;

    @ApiModelProperty(value = "火车描述")
    private String description;

    @ApiModelProperty(value = "状态更新时间")
    private String creationtime;

    @ApiModelProperty(value = "车辆所属的站点")
    private Integer site_id;
    
    @ApiModelProperty(value = "车辆当前位置")
    private Integer cur_addr_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(String creationtime) {
		this.creationtime = creationtime;
	}

	public Integer getSite_id() {
		return site_id;
	}

	public void setSite_id(Integer site_id) {
		this.site_id = site_id;
	}

	public Integer getCur_addr_id() {
		return cur_addr_id;
	}

	public void setCur_addr_id(Integer cur_addr_id) {
		this.cur_addr_id = cur_addr_id;
	}

	@Override
	public String toString() {
		return "Truck [id=" + id + ", name=" + name + ", num=" + num + ", description=" + description
				+ ", creationtime=" + creationtime + ", site_id=" + site_id + ", cur_addr_id=" + cur_addr_id + "]";
	}

    
}
