package com.express.mapper;

import com.express.entity.Order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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
public interface OrderMapper extends BaseMapper<Order> {
	/**
	 * 创建订单
	 */
   int insert(Order order);
   
   
   List<Order>  get(Order order);
   
   /**
       * 根据 id更新status。只有两个有效字段。
    * @param order
    * @return
    */
   int updateStatus(Order order);
   
   
   
 
   
   
}
