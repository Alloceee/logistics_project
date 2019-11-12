package com.express.service.impl;

import com.express.entity.Driver;
import com.express.mapper.DriverMapper;
import com.express.service.IDriverService;
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
public class DriverServiceImpl extends ServiceImpl<DriverMapper, Driver> implements IDriverService {

}
