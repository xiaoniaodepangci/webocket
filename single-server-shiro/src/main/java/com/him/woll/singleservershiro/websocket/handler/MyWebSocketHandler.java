package com.him.woll.singleservershiro.websocket.handler;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.him.woll.singleservershiro.entity.ImHistory;
import com.him.woll.singleservershiro.mapper.ImHistoryMapper;
import com.him.woll.singleservershiro.websocket.config.IWebSocketConfig;
import com.him.woll.singleservershiro.websocket.constants.MessageConstants;
import com.him.woll.singleservershiro.websocket.entity.MessagePayload;
import com.him.woll.singleservershiro.websocket.utils.MessagePayloadUtils;
import com.him.woll.singleservershiro.websocket.utils.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huangc
 * @version 1.0
 * @date 20/12/17 11:17
 */
@Slf4j
@Component
public class MyWebSocketHandler implements WebSocketHandler {
    @Autowired
    private ImHistoryMapper imHistoryMapper;


    /**
     * session对应关系
     */
    private static Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>();


    public static Map<String, WebSocketSession> getSessionMap() {
        return sessionMap;
    }

    public static void setSessionMap(Map<String, WebSocketSession> sessionMap) {
        MyWebSocketHandler.sessionMap = sessionMap;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        log.info("链接建立");
        IWebSocketConfig iWebSocketConfig = SpringContextUtils.getBean(IWebSocketConfig.class);
        String certificateSign = iWebSocketConfig.getCertificateSign();
        Object o = webSocketSession.getAttributes().get(certificateSign);
        if (!ObjectUtils.isEmpty(o)) {
            sessionMap.put(String.valueOf(o), webSocketSession);
        } else {
            Snowflake snowflake = IdUtil.getSnowflake(1, 1);
            sessionMap.put(String.valueOf(snowflake.nextId()), webSocketSession);
        }
    }


    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        MessagePayload messagePayload = null;
        try {
            messagePayload = JSONObject.parseObject((String) webSocketMessage.getPayload(), MessagePayload.class);
        } catch (Exception e) {
            log.error(e.toString());
            webSocketSession.sendMessage(MessagePayloadUtils.parseException());
            return;
        }
        if (messagePayload == null) {
            webSocketSession.sendMessage(MessagePayloadUtils.parseException());
            return;
        }
        // 测试
        String sender = messagePayload.getSender();
        String receiver = messagePayload.getReceiver();
        String type = messagePayload.getType();
        String content = messagePayload.getContent();
        // 心跳
        if (MessageConstants.MESSAGE_TYPE_HEART_BEAT.equals(type)) {
            log.info(messagePayload.toString());
            return;
        }
        // 广播
        if (MessageConstants.MESSAGE_TYPE_BROADCAST.equals(type)) {
            for (WebSocketSession localWebSocketSession : sessionMap.values()) {
                if (localWebSocketSession.isOpen()) {
                    localWebSocketSession.sendMessage(MessagePayloadUtils.success(sender,
                            receiver,
                            content,
                            MessageConstants.MESSAGE_TYPE_BROADCAST));
                }
            }
            return;
        }
        // 点对点
        if (MessageConstants.MESSAGE_TYPE_NORMAL.equals(type)) {
            log.info(" " + sender + "=>" + receiver + "  content=> " + content);
            WebSocketSession localWebSocketSession = sessionMap.getOrDefault(receiver, null);
            if (localWebSocketSession != null) {
                localWebSocketSession.sendMessage(MessagePayloadUtils.success(sender,
                        receiver,
                        content,
                        MessageConstants.MESSAGE_TYPE_NORMAL));
            }
            ImHistory history = new ImHistory();
            history.setState("0");
            history.setSender(sender);
            history.setReceiver(receiver);
            history.setMsg(content);
            history.setSign("0");
            imHistoryMapper.insert(history);
            return;
        }
        // 消息签收
        if (MessageConstants.MESSAGE_TYPE_SIGN.equals(type)) {
            JSONArray objects = JSONObject.parseArray(content);
            if (objects.size() != 0) {
                LambdaUpdateWrapper<ImHistory> updateWrapper = new LambdaUpdateWrapper<>();
                updateWrapper.set(ImHistory::getSign, "1").in(ImHistory::getHistoryId, objects);
                imHistoryMapper.update(null, updateWrapper);
                // 签收回执
                webSocketSession.sendMessage(MessagePayloadUtils.success(sender,
                        receiver,
                        content,
                        MessageConstants.MESSAGE_TYPE_SIGN));
            }
            return;
        }
        // 发送者空值检测
        if (StringUtils.isBlank(sender)) {
            webSocketSession.sendMessage(MessagePayloadUtils.noSenderException());
        }
        if (StringUtils.isBlank(receiver)) {
            webSocketSession.sendMessage(MessagePayloadUtils.noReceiverException());
        }
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        System.out.println("链接错误");
    }

    /**
     * 关闭
     *
     * @param webSocketSession webSocketSession
     * @param closeStatus      closeStatus
     * @throws Exception Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        IWebSocketConfig iWebSocketConfig = SpringContextUtils.getBean(IWebSocketConfig.class);
        String certificateSign = iWebSocketConfig.getCertificateSign();
        String o = (String) webSocketSession.getAttributes().get(certificateSign);
        sessionMap.remove(o);
        log.warn(o + "链接断开");
        System.out.println(sessionMap);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
