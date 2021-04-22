package com.him.woll.singleservershiro.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 群信息表
 * </p>
 *
 * @author huangc
 * @since 2021-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ImGroupUser extends Model<ImGroupUser> {

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
     * 主键
     */
    private String iguId;

    /**
     * 组id
     */
    private String groudId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 是否为管理员
     */
    private String admin;

    /**
     * 逻辑删除
     */
    private String state;


    @Override
    protected Serializable pkVal() {
        return this.iguId;
    }

}
