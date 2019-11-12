package com.express.mapper;

import com.express.entity.Orderstatus;

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
public interface OrderstatusMapper extends BaseMapper<Orderstatus> {
	
    int insert(Orderstatus od );
    
    List<Orderstatus> get(int order_id);
   
}
