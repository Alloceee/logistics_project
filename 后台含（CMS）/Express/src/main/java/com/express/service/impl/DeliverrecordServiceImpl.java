package com.express.service.impl;

import com.express.bean.common.ResultData;
import com.express.entity.Deliverrecord;
import com.express.entity.Deliverrecorddetail;
import com.express.entity.Order;
import com.express.entity.Orderstatus;
import com.express.entity.Worker;
import com.express.entity.ext.BindDeliverVO;
import com.express.entity.ext.UpdateOrderList;
import com.express.mapper.DeliverrecordMapper;
import com.express.mapper.OrderstatusMapper;
import com.express.service.IDeliverrecordService;
import com.express.service.IOrderService;

import io.swagger.annotations.ApiOperation;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
@Service
public class DeliverrecordServiceImpl extends ServiceImpl<DeliverrecordMapper, Deliverrecord> implements IDeliverrecordService {

	 @Autowired
	 private DeliverrecordMapper mapper;
	
	 @Autowired
	 private OrderstatusMapper order_status_mapper;
 
     public ResultData insert( Deliverrecord record) {
		 int row = mapper.insert(record);
		 if(row > 0)
		 return ResultData.success().setData(record);
		 else return ResultData.fail("创建失败");
     }
	
	 
     public ResultData get( Deliverrecord record) {
		return ResultData.success().setData( mapper.getBase(record));
     }
	
     
	 public ResultData getDetail( Deliverrecord record) {
		return ResultData.success().setData(  mapper.getDetail(record) );
     }
	
	 
     public ResultData bindDeliverRecord( BindDeliverVO bindvo ) {
    	 //1 检测 发货单的状态是否为1 未发货的情况下，才可以绑定发货单。
    	/* Deliverrecord query = new Deliverrecord();
    	 query.setId(  bindvo.getDeliver_id() );
 		 List<Deliverrecord> listrecord = mapper.getBase( query  );
 		 if(listrecord !=null && listrecord.size() > 0) {
 			Deliverrecord rd = listrecord.get(0);
 			if(rd.getStatus() !=1 ) {
 				return ResultData.fail("订单已发货，不能绑定货物！");
 			}
 		 }*/
 		//2 写入发货细表： 	 
		try {
			mapper.insertDetail(bindvo);
		}catch (Exception e) {
		     return ResultData.fail("该货物已被扫描过");
		}
		
		//3更新发货记录表的货物数量字段。
	    mapper.updateGoodzTotal(bindvo.getDeliver_id() );
	    
	    //4 写入订单状态表： 当前快递员已经取件。
	    Orderstatus odstatus = new Orderstatus();
	    odstatus.setOrder_id( bindvo.getOrder_id() );
	    odstatus.setSite_id( bindvo.getSite_id() );
	    odstatus.setStatus_desc("分拣员【工号"+bindvo.getWorker_id()+"】正在分拣，即将发货");
	    order_status_mapper.insert(odstatus);
	    
		return ResultData.success();
		
     }
	
     public ResultData  unbindDeliverRecord( Deliverrecorddetail detail ) {
    	 int row = mapper.removeDetail(detail);
    	 if( row > 0) {
    		 return  ResultData.success(); 
    	 }else {
    		 return ResultData.fail();
    	 }
     }
     
    
     
	@Override
	public ResultData deliver(int deliver_id ,Worker wk) {
		//1 修改发货单状态为已发货。
		 Deliverrecord record = new Deliverrecord();
		 record.setId(deliver_id);
		 record.setStatus(2);
		 mapper.updateStatus(record);
		 
		 //2 修改该发货单下面的每个订单的状态为：   
		 mapper.updateOrderStatusById(3, deliver_id);
		 
		 
		 
	   //3 同时新增  orderstatus表格记录。
		List<Order> orderlist = mapper.getOrderListById(deliver_id);
		Orderstatus odstatus = new Orderstatus();
		odstatus.setSite_id( wk.getSite_id() );//站点id从操作人员信息中获取。
		odstatus.setStatus_desc("操作人员【工号"+wk.getId()+"】正在发货。");
		for(Order order :orderlist) {
			odstatus.setOrder_id( order.getId() );//order_id赋值
			order_status_mapper.insert(odstatus);
		}
		 return ResultData.success();
	}


	@Override
	public ResultData getOrderListById(int id) {
		return ResultData.success().setData(mapper.getOrderListById(id));
	}
}
