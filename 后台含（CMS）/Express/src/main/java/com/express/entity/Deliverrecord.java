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
@ApiModel(value="发货单对象", description="")
public class Deliverrecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("发货单")
    private Integer id;
    
    @ApiModelProperty("路线id")
    private Integer route_id;
    
    @ApiModelProperty("货物总数")
    private Integer goodz_total;
    
    @ApiModelProperty("车辆id")
    private Integer truck_id;
    @ApiModelProperty("驾驶员id")
    private Integer driver_id;
    @ApiModelProperty("订单创建时间")
    private String creationtime;
    @ApiModelProperty("发货单状态：1 未发货  2 已发货   3到达目的地。")
    private Integer status;
    @ApiModelProperty("发货时间")
    private String sendtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoute_id() {
		return route_id;
	}
	public void setRoute_id(Integer route_id) {
		this.route_id = route_id;
	}
	public Integer getGoodz_total() {
		return goodz_total;
	}
	public void setGoodz_total(Integer goodz_total) {
		this.goodz_total = goodz_total;
	}
	public Integer getTruck_id() {
		return truck_id;
	}
	public void setTruck_id(Integer truck_id) {
		this.truck_id = truck_id;
	}
	public Integer getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(Integer driver_id) {
		this.driver_id = driver_id;
	}
	public String getCreationtime() {
		return creationtime;
	}
	public void setCreationtime(String creationtime) {
		this.creationtime = creationtime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	
	
	@Override
	public String toString() {
		return "Deliverrecord [id=" + id + ", route_id=" + route_id + ", goodz_total=" + goodz_total + ", truck_id="
				+ truck_id + ", driver_id=" + driver_id + ", creationtime=" + creationtime + ", status=" + status
				+ ", sendtime=" + sendtime + "]";
	}
    
    
    
}

