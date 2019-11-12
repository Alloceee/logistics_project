package com.express.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.express.bean.common.ResultData;
import com.express.entity.Order;
import com.express.entity.Orderstatus;
import com.express.entity.ext.UpdateOrder;
import com.express.entity.ext.UpdateOrderList;
import com.express.mapper.OrderMapper;
import com.express.mapper.OrderstatusMapper;
import com.express.service.IOrderService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
	@Autowired
	private OrderMapper mapper;
	
	@Autowired
	private OrderstatusMapper statusmapper;
	
	@Override
	public ResultData updateStatus(UpdateOrder updateorder) {
		//1 更新订单的状态。
		int row = mapper.updateStatus( updateorder.getOrder() );
		//2 写一条记录到订单状态记录表中。
		Orderstatus odstatus = updateorder.getOrderstatus();
		row += statusmapper.insert(odstatus);
		return  new ResultData(); 
	}

	@Override
	public ResultData updateStatus(UpdateOrderList odlist) {
		int[] ids = odlist.getIds();
		//int status =odlist.getStatus();
		Orderstatus updatemodel = odlist.getOrderstatus();//订单里包含了   status和addr_id以及desc都由前端传入。
		//Order order = new Order();
		for(int id : ids) { 
			//order.setId( id );
			//order.setStatus(status);
			//mapper.updateStatus( order );//1多个人的订单状态同时更新。
			
			updatemodel.setOrder_id( id );
			statusmapper.insert(updatemodel);//2多个人的订单记录同时被写入。
		 }
		return ResultData.success();
	}

}
