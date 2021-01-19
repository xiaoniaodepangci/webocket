package com.him.woll.singleservershiro.service.impl;

import com.him.woll.singleservershiro.entity.ChatMsg;
import com.him.woll.singleservershiro.mapper.ChatMsgMapper;
import com.him.woll.singleservershiro.service.IChatMsgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangc
 * @since 2021-01-19
 */
@Service
public class ChatMsgServiceImpl extends ServiceImpl<ChatMsgMapper, ChatMsg> implements IChatMsgService {

}
