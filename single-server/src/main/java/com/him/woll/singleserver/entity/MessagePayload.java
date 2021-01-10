package com.him.woll.singleserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author huangchuan
 * @version 1.0
 * @date 2021-01-09 16:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessagePayload {
    /**
     * 发送者
     */
    private String sender;

    /**
     * 接收者
     */
    private String receiver;

    /**
     * 内容
     */
    private String content;

    /**
     * 消息类型
     */
    private String type;

    /**
     * 当前用户的token
     */
    private String token;
}
