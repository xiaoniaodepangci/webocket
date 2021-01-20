package com.him.woll.singleservershiro.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author huangc
 * @since 2021-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 权限
     */
    private String permission;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
