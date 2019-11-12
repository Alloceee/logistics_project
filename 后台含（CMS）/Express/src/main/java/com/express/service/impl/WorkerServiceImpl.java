package com.express.service.impl;

import com.express.entity.Worker;
import com.express.mapper.WorkerMapper;
import com.express.service.IWorkerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author haiger412
 * @since 2019-10-13
 */
@Service
public class WorkerServiceImpl extends ServiceImpl<WorkerMapper, Worker> implements IWorkerService {

}
