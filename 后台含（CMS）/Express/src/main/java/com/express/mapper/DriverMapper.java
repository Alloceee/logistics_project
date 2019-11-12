package com.express.mapper;

import com.express.entity.Driver;
import com.express.entity.Truck;

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
public interface DriverMapper extends BaseMapper<Driver> {
	 int insert(Driver driver);
    
	 int deleteById(int id);
	 
	 List<Driver> get(Driver driver);
	 
	 List<Driver> getAll( ); 
     
}
