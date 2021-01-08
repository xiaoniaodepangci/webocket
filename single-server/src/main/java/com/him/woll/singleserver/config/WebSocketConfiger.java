package com.him.woll.singleserver.config;

import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * websocket的配置类
 *
 * @author huangc
 * @version 1.0
 * @date 21/01/08 16:44
 */
public class WebSocketConfiger implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

    }
}
