package com.him.woll.singleservershiro.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.him.woll.singleservershiro.common.Pageable;
import com.him.woll.singleservershiro.common.Result;
import com.him.woll.singleservershiro.entity.ImHistory;
import com.him.woll.singleservershiro.entity.SysUser;
import com.him.woll.singleservershiro.mapper.ImHistoryMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/history")
public class HistoryController {
    private final ImHistoryMapper historyMapper;

    public HistoryController(ImHistoryMapper historyMapper) {
        this.historyMapper = historyMapper;
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
        SysUser users = (SysUser) SecurityUtils.getSubject().getPrincipal();
        Page<ImHistory> page = new Page<>(pageable.getCurrPage(), pageable.getPageSize());
        Page<ImHistory> history = historyMapper.history(page, receiver, users.getUserId());
        return Result.list(history.getRecords(),
                history.getCurrent(),
                history.getSize(),
                history.getPages(),
                history.getTotal());
    }
}

