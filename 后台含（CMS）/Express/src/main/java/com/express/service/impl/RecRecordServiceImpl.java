package com.express.service.impl;

import com.express.bean.common.ResultData;
import com.express.entity.Address;
import com.express.entity.Deliverrecord;
import com.express.entity.Order;
import com.express.entity.Orderstatus;
import com.express.entity.RecRecord;
import com.express.entity.Worker;
import com.express.mapper.AddressMapper;
import com.express.mapper.DeliverrecordMapper;
import com.express.mapper.OrderstatusMapper;
import com.express.mapper.RecRecordMapper;
import com.express.service.RecRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
@Service
public class RecRecordServiceImpl extends ServiceImpl<RecRecordMapper, RecRecord> implements RecRecordService {
	@Autowired
	private DeliverrecordMapper deliver_mapper;
	
	@Autowired
	private OrderstatusMapper orderstatusmapper;
	
	@Override
	public ResultData insert(RecRecord record,Worker wk) {
		//2重复签收。
		try {
			this.getBaseMapper().insert(record);
		} catch (Exception e) {
			return ResultData.fail("请不要重复签收！");
		}
		
		//3 写入 orderstatus表。提示到达中转站。
		List<Order> orderlist = deliver_mapper.getOrderListById( record.getDeliver_id() );
		Orderstatus odstatus = new Orderstatus();
		odstatus.setSite_id( wk.getSite_id() );//站点id从操作人员信息中获取。
		odstatus.setStatus_desc("操作人员【工号"+wk.getId()+"】已收货");
		for(Order order :orderlist) {
			odstatus.setOrder_id( order.getId() );//order_id赋值
			orderstatusmapper.insert(odstatus);
		}
		return ResultData.success("签收成功！");
	}

	@Override
	public ResultData getDetail(int deliver_id) {
		return ResultData.success().setData(  this.getBaseMapper().getDetail(deliver_id) );
	}

}
