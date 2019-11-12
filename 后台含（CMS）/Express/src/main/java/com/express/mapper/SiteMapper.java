package com.express.mapper;
 
import com.express.entity.Site;

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
public interface SiteMapper extends BaseMapper<Site> {
	/**
	 * 添加地址。
	 */
	int insert(Site add);
	
	/**
	 * 查询所有地址。。
	 * @return
	 */
	List<Site> getAll();
	
	/**
	 * 单个查询。
	 * @param id
	 * @return
	 */
	Site byId(int id);
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	int deleteById(int id);
}
