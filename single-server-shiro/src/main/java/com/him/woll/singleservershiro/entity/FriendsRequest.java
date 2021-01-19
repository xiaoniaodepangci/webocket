package com.him.woll.singleservershiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
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
public class FriendsRequest extends Model<FriendsRequest> {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 请求发送者
     */
    private String sender;

    /**
     * 请求接收者
     */
    private String receiver;

    /**
     * 请求时间
     */
    private Date requestDateTime;

    /**
     * 本请求状态
     */
    private String status;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
