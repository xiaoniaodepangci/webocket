package com.him.woll.singleservershiro.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色权限中间表
 * </p>
 *
 * @author huangc
 * @since 2021-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RolePermission extends Model<RolePermission> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 权限id
     */
    private String permissionId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
