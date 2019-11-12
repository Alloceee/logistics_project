package com.express.service;

import com.express.bean.common.ResultData;
import com.express.entity.Address;
import com.express.entity.RecRecord;
import com.express.entity.Worker;

import org.springframework.web.bind.annotation.RequestBody;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
public interface RecRecordService extends IService<RecRecord> {
	 ResultData getDetail(int deliver_id);
	 ResultData insert( RecRecord record,Worker wk);
}
