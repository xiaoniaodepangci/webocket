package com.him.woll.singleserver.interceptors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * ws握手请求拦截器
 *
 * @author huangc
 * @version 1.0
 * @date 20/12/17 15:14
 */
@Component
public class MyHandshakeInterceptor implements HandshakeInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(HandshakeInterceptor.class);

    /**
     * 握手之前，若返回false，则不建立链接 *
     *
     * @param request    请求
     * @param response   响应
     * @param wsHandler  ws的处理器
     * @param attributes 携带的参数
     * @return 是否能够连接 true可 false否
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse
            response, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        LOGGER.info("before handshake 。。。。。。。");
        ServletServerHttpRequest serverHttpRequest = (ServletServerHttpRequest) request;
        //获取参数
        serverHttpRequest.getHeaders();
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse
            response, WebSocketHandler wsHandler, Exception exception) {
        LOGGER.info("after handShake。。。。。。");
    }
}

