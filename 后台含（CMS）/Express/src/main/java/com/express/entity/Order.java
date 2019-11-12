package com.express.entity;
 
import java.io.Serializable;
import java.math.BigDecimal;

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
@ApiModel(value="Order对象", description="")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty("订单号 从 201910160开始")
    private Integer id;
    @ApiModelProperty("用户的微信id")
    private String openid;
    
    @ApiModelProperty("接收端用户的微信id。预留以后扩展用。实现我的好友。直接接过去。省去地址。")
    private String rec_openid;
    
    @ApiModelProperty("发件人姓名")
    private String send_username;
    @ApiModelProperty("发件仓库：只能从数据库中选。用于追踪位置。")
    private String send_site_id;
    @ApiModelProperty("发件详细地址。可以自己写。")
    private String send_addr_detail;
    @ApiModelProperty("发件人电话")
    private String send_tel;
    
    @ApiModelProperty("收件人姓名")
    private String rec_username;
    @ApiModelProperty("收件仓库：只能从数据库中选。用于追踪位置。")
    private String rec_site_id;
    @ApiModelProperty("收件详细地址。可以自己写。")
    private String rec_addr_detail;
    @ApiModelProperty("收件人电话")
    private String rec_tel;
    
    @ApiModelProperty("邮筒id。")
    private Integer box_id; 
    
    @ApiModelProperty("下单时间")
    private String creationtime; 
    
    @ApiModelProperty("重量")
    private String weight;
    
    @ApiModelProperty("体积")
    private String volume;
    
    @ApiModelProperty("价格")
    private BigDecimal price;
    
    @ApiModelProperty("状态 1未收件  2已收件未发货  3 已发货未送达  4已送达未派件  5 派件未签收  6 用户已经签收")
    private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSend_username() {
		return send_username;
	}

	public void setSend_username(String send_username) {
		this.send_username = send_username;
	}

	public String getSend_site_id() {
		return send_site_id;
	}

	public void setSend_site_id(String send_site_id) {
		this.send_site_id = send_site_id;
	}

	public String getSend_addr_detail() {
		return send_addr_detail;
	}

	public void setSend_addr_detail(String send_addr_detail) {
		this.send_addr_detail = send_addr_detail;
	}

	public String getSend_tel() {
		return send_tel;
	}

	public void setSend_tel(String send_tel) {
		this.send_tel = send_tel;
	}

	public String getRec_username() {
		return rec_username;
	}

	public void setRec_username(String rec_username) {
		this.rec_username = rec_username;
	}

	public String getRec_site_id() {
		return rec_site_id;
	}

	public void setRec_site_id(String rec_site_id) {
		this.rec_site_id = rec_site_id;
	}

	public String getRec_addr_detail() {
		return rec_addr_detail;
	}

	public void setRec_addr_detail(String rec_addr_detail) {
		this.rec_addr_detail = rec_addr_detail;
	}

	public String getRec_tel() {
		return rec_tel;
	}

	public void setRec_tel(String rec_tel) {
		this.rec_tel = rec_tel;
	}

	public Integer getBox_id() {
		return box_id;
	}

	public void setBox_id(Integer box_id) {
		this.box_id = box_id;
	}

	public String getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(String creationtime) {
		this.creationtime = creationtime;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRec_openid() {
		return rec_openid;
	}

	public void setRec_openid(String rec_openid) {
		this.rec_openid = rec_openid;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", openid=" + openid + ", rec_openid=" + rec_openid + ", send_username="
				+ send_username + ", send_site_id=" + send_site_id + ", send_addr_detail=" + send_addr_detail
				+ ", send_tel=" + send_tel + ", rec_username=" + rec_username + ", rec_site_id=" + rec_site_id
				+ ", rec_addr_detail=" + rec_addr_detail + ", rec_tel=" + rec_tel + ", box_id=" + box_id
				+ ", creationtime=" + creationtime + ", weight=" + weight + ", volume=" + volume + ", price=" + price
				+ ", status=" + status + "]";
	}
    
}
