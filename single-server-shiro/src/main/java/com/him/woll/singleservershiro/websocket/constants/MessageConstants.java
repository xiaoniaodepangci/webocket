package com.him.woll.singleservershiro.websocket.constants;

/**
 * 常量
 *
 * @author huangchuan
 * @version 1.0
 * @date 2021-01-09 16:36
 */
public class MessageConstants {
    /**
     * 消息类型---心跳包
     */
    public static final String MESSAGE_TYPE_HEART_BEAT = "heartBeat";
    /**
     * 消息类型---正常类型的消息
     */
    public static final String MESSAGE_TYPE_NORMAL = "normal";

    /**
     * 消息类型---广播消息
     */
    public static final String MESSAGE_TYPE_BROADCAST = "broadcast";
    /**
     * 消息类型---签收
     */
    public static final String MESSAGE_TYPE_SIGN = "sign";
    /**
     * 消息类型---撤销
     */
    public static final String MESSAGE_TYPE_REVOKE = "revoke";
}
