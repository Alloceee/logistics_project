package com.express.mapper;

import com.express.entity.Deliverrecord;
import com.express.entity.Deliverrecorddetail;
import com.express.entity.Order;
import com.express.entity.ext.DeliverrecordVO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
@Mapper
public interface DeliverrecordMapper extends BaseMapper<Deliverrecord> {
	
    int insert(Deliverrecord record);
    
    List<Deliverrecord> getBase(Deliverrecord record);
    /**
          * 多表关联查询。
     * @param id
     * @return
     */
    List<DeliverrecordVO> getDetail(Deliverrecord record);
    
    /**
	     * 更新发货信息。不包含含发货状态。
	     更新的前提是：该发货单未发货，即状态为1。一旦发货，不允许任何修改。
     * @param record
     * @return
     */
    int update(Deliverrecord record);
    
    /**
         *  根据发货单id更新发货状态。
      更新的是发货记录表。
     * @param record
     * @return
     */
    int updateStatus(Deliverrecord record);
    
    int updateGoodzTotal(int id);
    
    
    /**
           * 添加货物记录。也就是将发货单和货物绑定在一起。
     * @param recorddetail
     * @return
     */
    int insertDetail( Deliverrecorddetail recorddetail );
    
    /**
     * 移除
     * @param recorddetail
     * @return
     */
    int removeDetail( Deliverrecorddetail recorddetail );
    
    /**
     * 根据发货单号获取发货清单列表。
     * @param id
     * @return
     */
    List<Order> getOrderListById(int id);
    
    /**
           * 主表：ex_order  从表
         * 注意这里更新的是用户订单 表(order )，不是平台内部的发货记录表(deliverrecord)。
     * @param id
     * @return
     */
    int updateOrderStatusById(@Param("status")int status,@Param("deliver_id")int deliver_id);
}
