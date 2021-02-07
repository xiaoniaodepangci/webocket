package com.him.woll.singleservershiro.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.him.woll.singleservershiro.entity.ChatMsg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author huangc
 * @since 2021-01-19
 */
@Mapper
@Repository
public interface ChatMsgMapper extends BaseMapper<ChatMsg> {


    /**
     * 查询历史记录
     *
     * @param page 分页
     * @param receiver 接受者
     * @param sender 发送者
     * @return 查询历史记录
     */
    Page<ChatMsg> history(IPage<ChatMsg> page, @Param("receiver") String receiver, @Param("sender") String sender);
}
