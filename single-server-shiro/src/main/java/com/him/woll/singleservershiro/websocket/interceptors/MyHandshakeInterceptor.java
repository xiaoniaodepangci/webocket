package com.him.woll.singleservershiro.websocket.interceptors;


import com.him.woll.singleservershiro.shiro.kit.JwtUtil;
import com.him.woll.singleservershiro.websocket.config.IWebSocketConfig;
import com.him.woll.singleservershiro.websocket.utils.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
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
@Configuration
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
        IWebSocketConfig iWebSocketConfig = SpringContextUtils.getBean(IWebSocketConfig.class);
        String certificateSign = iWebSocketConfig.getCertificateSign();
        ServletServerHttpRequest serverHttpRequest = (ServletServerHttpRequest) request;
        String token = serverHttpRequest.getServletRequest().getParameter(iWebSocketConfig.getCertificateSign());

        String username = JwtUtil.getUsername(token);
        attributes.put(certificateSign, username);
        return JwtUtil.verify(token, username);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse
            response, WebSocketHandler wsHandler, Exception exception) {
        LOGGER.info("after handShake。。。。。。");
    }
}

