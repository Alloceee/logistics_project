package com.express.service;

import com.express.bean.common.ResultData;
import com.express.entity.Order;
import com.express.entity.ext.UpdateOrder;
import com.express.entity.ext.UpdateOrderList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
public interface IOrderService extends IService<Order> {
	/**
	 * 更新单个订单的状态。
	 * @param id
	 * @param status
	 * @return
	 */
    ResultData updateStatus(UpdateOrder updateorder);
    /**
         * 更新多个订单的状态。并同时写入到订单记录表中。 
     * @param id
     * @param status
     * @return
     */
    ResultData updateStatus(UpdateOrderList odlist);
}
