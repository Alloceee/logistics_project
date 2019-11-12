package com.express.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.entity.Worker;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
@Mapper
public interface WorkerMapper extends BaseMapper<Worker> {
   List<Worker> getAll();
    
   int insert(Worker wk);
  
   int deleteById(int id);
   
   Worker get(Worker wk);
   
   List<Worker> getAllDetail( );
}
