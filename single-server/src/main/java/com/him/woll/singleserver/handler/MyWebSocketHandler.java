package com.him.woll.singleserver.handler;

import org.slf4j.LoggerFactory;
import org.springframework.web.socket.*;

import javax.swing.text.TabableView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huangc
 * @version 1.0
 * @date 20/12/17 11:17
 */

public class MyWebSocketHandler implements WebSocketHandler {

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
        System.out.println("链接建立");
        sessionMap.put(String.valueOf(webSocketSession.getAttributes().get("id")), webSocketSession);
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        System.out.println("服务端收到消息");
        String payload = (String) webSocketMessage.getPayload();
        System.out.println("载荷=>" + payload);
        System.out.println("发送方id=" + webSocketSession.getAttributes().get("id"));
        TextMessage textMessage = null;
        if (payload.equals("heartBeat")) {
            textMessage = new TextMessage("心跳包已收到");
        } else {
            textMessage = new TextMessage("消息体已收到==>" + payload);
        }
        webSocketSession.sendMessage(textMessage);
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
        Long id = (Long) webSocketSession.getAttributes().get("id");
        System.out.println(id);
        System.out.println("链接断开");
        sessionMap.remove(id.toString());
        System.out.println(sessionMap);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
