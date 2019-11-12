package com.express.service.impl;

import com.express.entity.Mailbox;
import com.express.mapper.MailboxMapper;
import com.express.service.IMailboxService;
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
public class MailboxServiceImpl extends ServiceImpl<MailboxMapper, Mailbox> implements IMailboxService {

}
