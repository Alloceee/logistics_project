package com.express.mapper;

import com.express.entity.Mailbox;

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
public interface MailboxMapper extends BaseMapper<Mailbox> {
	/**
	 * 添加邮筒
	 */
   int insert(Mailbox box);
   
   /***
    *  获取站点的邮筒。
    * @param site_id
    * @return
    */
   List<Mailbox> getBySiteId(int site_id);
   
   /**
    * 删除邮筒
    * @param id
    * @return
    */
   int deleteById(int id);
   
   /**
    * 根据邮筒编号查找邮筒
    * @param id
    * @return
    */
   Mailbox getById( int id);
   
}
