package com.him.woll.singleservershiro.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.him.woll.singleservershiro.entity.ImHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 聊天记录表 Mapper 接口
 * </p>
 *
 * @author huangc
 * @since 2021-04-21
 */
@Mapper
@Repository
public interface ImHistoryMapper extends BaseMapper<ImHistory> {
    /**
     * 查询历史记录
     *
     * @param page     分页
     * @param receiver 接受者
     * @param sender   发送者
     * @return 查询历史记录
     */
    Page<ImHistory> history(IPage<ImHistory> page, @Param("receiver") String receiver, @Param("sender") String sender);

}
