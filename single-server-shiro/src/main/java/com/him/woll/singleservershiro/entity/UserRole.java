package com.him.woll.singleservershiro.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author huangc
 * @since 2021-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 主键
     */
    private String id;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
