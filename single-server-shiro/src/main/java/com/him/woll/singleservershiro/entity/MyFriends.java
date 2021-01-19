package com.him.woll.singleservershiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangc
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MyFriends extends Model<MyFriends> {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 本人id
     */
    private String myUserId;

    /**
     * 朋友id
     */
    private String myFriendUserId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
