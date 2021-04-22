package com.him.woll.singleservershiro.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 聊天组
 * </p>
 *
 * @author huangc
 * @since 2021-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ImGroup extends Model<ImGroup> {

    private static final long serialVersionUID = 1L;

    /**
     * 乐观锁
     */
    private Integer revision;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;

    /**
     * 组id
     */
    private String groupId;

    /**
     * 组名
     */
    private String groupName;

    /**
     * 群主
     */
    private String owner;

    /**
     * 逻辑删除
     */
    private String state;


    @Override
    protected Serializable pkVal() {
        return this.groupId;
    }

}
