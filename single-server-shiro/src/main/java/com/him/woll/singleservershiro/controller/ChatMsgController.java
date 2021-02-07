package com.him.woll.singleservershiro.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.him.woll.singleservershiro.common.Pageable;
import com.him.woll.singleservershiro.common.Result;
import com.him.woll.singleservershiro.entity.ChatMsg;
import com.him.woll.singleservershiro.entity.Users;
import com.him.woll.singleservershiro.mapper.ChatMsgMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author huangc
 * @since 2021-01-19
 */
@RestController
@RequestMapping("/chatMsg")
public class ChatMsgController {
    private final ChatMsgMapper chatMsgMapper;

    public ChatMsgController(ChatMsgMapper chatMsgMapper) {
        this.chatMsgMapper = chatMsgMapper;
    }

    /**
     * 历史消息获取接口
     *
     * @param receiver 需要获取谁的聊天记录
     * @param pageable 分页工具
     * @return 聊天记录
     */
    @GetMapping("/history")
    public Result history(String receiver, Pageable pageable) {
        Users users = (Users) SecurityUtils.getSubject().getPrincipal();
        Page<ChatMsg> page = new Page<>(pageable.getCurrPage(), pageable.getPageSize());
        Page<ChatMsg> history = chatMsgMapper.history(page, receiver, users.getId());
        return Result.list(history.getRecords(),
                history.getCurrent(),
                history.getSize(),
                history.getPages(),
                history.getTotal());
    }
}

