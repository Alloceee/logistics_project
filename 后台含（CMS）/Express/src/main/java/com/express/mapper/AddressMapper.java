package com.express.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.entity.Address;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {
	/**
	 * 添加地址。
	 */
	int insert(Address add);
	
	/**
	 * 查询所有地址。。
	 * @return
	 */
	List<Address> getAll();
	
	/**
	 * 单个查询。
	 * @param id
	 * @return
	 */
	Address byId(int id);
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	int deleteById(int id);
	
}
