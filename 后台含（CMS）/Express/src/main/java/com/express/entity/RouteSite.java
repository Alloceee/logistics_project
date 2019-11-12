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
@ApiModel(value="Route对象", description="")
public class RouteSite implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "路线id")
    private Integer route_id;

    @ApiModelProperty(value = "站点id")
    private Integer site_id;

    @ApiModelProperty(value = "顺序")
    private Integer seq;

	public Integer getRoute_id() {
		return route_id;
	}

	public void setRoute_id(Integer route_id) {
		this.route_id = route_id;
	}

	public Integer getSite_id() {
		return site_id;
	}

	public void setSite_id(Integer site_id) {
		this.site_id = site_id;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "RouteSite [route_id=" + route_id + ", site_id=" + site_id + ", seq=" + seq + "]";
	}

     
     
}
