package com.express.mapper;

import com.express.entity.Admin;

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
public interface AdminMapper extends BaseMapper<Admin> {
	
	Admin login(Admin  admin);
}
