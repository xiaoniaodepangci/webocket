package com.him.woll.singleservershiro.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 好友申请记录表
 * </p>
 *
 * @author huangc
 * @since 2021-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ImRequest extends Model<ImRequest> {

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
     * 主键
     */
    private String imRequestId;

    /**
     * 请求发送方
     */
    private String sendUserId;

    /**
     * 请求接收方
     */
    private String receiveUserId;

    /**
     * 是否已签收
     */
    private String sign;

    /**
     * 是否已结束
     */
    private String status;

    /**
     * 逻辑删除
     */
    private String state;


    @Override
    protected Serializable pkVal() {
        return this.imRequestId;
    }

}
