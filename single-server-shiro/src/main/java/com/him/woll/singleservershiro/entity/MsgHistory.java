package com.him.woll.singleservershiro.entity;

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
 * @since 2021-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MsgHistory extends Model<MsgHistory> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 发送者
     */
    private String sender;

    /**
     * 接受者
     */
    private String receiver;

    /**
     * 内容
     */
    private String content;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
