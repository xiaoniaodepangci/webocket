package com.him.woll.singleservershiro.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author huangc
 * @since 2021-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 角色名
     */
    private String roleName;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
