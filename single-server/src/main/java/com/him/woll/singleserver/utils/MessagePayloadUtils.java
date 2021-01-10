package com.him.woll.singleserver.utils;

import com.alibaba.fastjson.JSONObject;
import com.him.woll.singleserver.constants.MessageConstants;
import com.him.woll.singleserver.entity.MessagePayload;
import org.springframework.web.socket.TextMessage;
import org.w3c.dom.Text;

/**
 * 工具
 *
 * @author huangchuan
 * @version 1.0
 * @date 2021-01-09 17:20
 */
public class MessagePayloadUtils {

    /**
     * 消息体转换失败
     *
     * @return TextMessage
     */
    public static TextMessage parseException() {
        MessagePayload messagePayload = new MessagePayload();
        messagePayload.setContent("消息体序列化错误");
        messagePayload.setSender("system");
        messagePayload.setReceiver("");
        messagePayload.setType("error");
        return new TextMessage(JSONObject.toJSONString(messagePayload));
    }

    /**
     * 无发送者错误
     *
     * @return TextMessage
     */
    public static TextMessage noSenderException() {
        MessagePayload messagePayload = new MessagePayload();
        messagePayload.setContent("请指定发送者");
        messagePayload.setSender("system");
        messagePayload.setReceiver("");
        messagePayload.setType("error");
        return new TextMessage(JSONObject.toJSONString(messagePayload));
    }
    /**
     * 无接收者错误
     *
     * @return TextMessage
     */
    public static TextMessage noReceiverException() {
        MessagePayload messagePayload = new MessagePayload();
        messagePayload.setContent("请指定接收者");
        messagePayload.setSender("system");
        messagePayload.setReceiver("");
        messagePayload.setType("error");
        return new TextMessage(JSONObject.toJSONString(messagePayload));
    }

    public static TextMessage success(String sender, String receiver, String content) {
        MessagePayload messagePayload = new MessagePayload();
        messagePayload.setContent(content);
        messagePayload.setSender(sender);
        messagePayload.setReceiver(receiver);
        messagePayload.setType(MessageConstants.MESSAGE_TYPE_NORMAL);
        return new TextMessage(JSONObject.toJSONString(messagePayload));
    }
}
