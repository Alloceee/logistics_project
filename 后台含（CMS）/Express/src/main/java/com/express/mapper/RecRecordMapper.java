package com.express.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.express.entity.RecRecord;
import com.express.entity.ext.RecRecordVO;

@Mapper
public interface RecRecordMapper extends BaseMapper<RecRecord>{
	 /**
	  * 添加收货记录
	  */
	 int insert(RecRecord record );
	 /**
	  *  根据发货单，查询收货记录。RecRecordVO
	  * @param deliver_id
	  * @return
	  */
	 List<RecRecordVO> getDetail(int deliver_id);
	 
}
