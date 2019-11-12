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
@ApiModel(value="Deliverrecorddetail对象", description="")
public class Deliverrecorddetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("发货单id")
    private int deliver_id;
    @ApiModelProperty("订单id")
    private int order_id;
	public int getDeliver_id() {
		return deliver_id;
	}
	public void setDeliver_id(int deliver_id) {
		this.deliver_id = deliver_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	@Override
	public String toString() {
		return "Deliverrecorddetail [deliver_id=" + deliver_id + ", order_id=" + order_id + "]";
	}
    
    
}
