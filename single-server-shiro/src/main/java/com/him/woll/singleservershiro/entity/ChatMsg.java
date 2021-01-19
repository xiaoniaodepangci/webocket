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
public class ChatMsg extends Model<ChatMsg> {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 发送者
     */
    private String sender;

    /**
     * 接收者
     */
    private String receiver;

    /**
     * 消息实体
     */
    private String msg;

    /**
     * 接收标志
     */
    private String signFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 消息状态
     */
    private String status;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
