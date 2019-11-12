package com.express.service;

import com.express.bean.common.ResultData;
import com.express.entity.Deliverrecord;
import com.express.entity.Deliverrecorddetail;
import com.express.entity.Orderstatus;
import com.express.entity.Worker;
import com.express.entity.ext.BindDeliverVO;

import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
public interface IDeliverrecordService extends IService<Deliverrecord> {
	ResultData insert( Deliverrecord record);
	
	
	ResultData get( Deliverrecord record) ;
	
	ResultData getDetail( Deliverrecord record);
	
	
	
	 
   ResultData bindDeliverRecord( BindDeliverVO bindvo );
	
	 
   ResultData  unbindDeliverRecord( Deliverrecorddetail detail ) ;
  /**
   * 发货 
   * @param deliver_id   发货单id
   * @param wk  操作人员信息。
   * @return
   */
   ResultData deliver(int deliver_id,Worker wk);
   
   /**
    * 根据发货单号获取发货清单的所有物件。
    * @param id
    * @return
    */
   ResultData getOrderListById(int id);
}
