package com.him.woll.singleserver.config;

import com.him.woll.singleserver.handler.MyWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * websocket的配置类
 *
 * @author huangc
 * @version 1.0
 * @date 21/01/08 16:44
 */
@Configuration
public class IWebSocketConfigurer implements WebSocketConfigurer {
    @Autowired
    private IWebSocketConfig iWebSocketConfig;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        List<String> crossOrigins = iWebSocketConfig.getCrossOrigins();
        registry.addHandler(webSocketHandler(), iWebSocketConfig.getEndpoint())
                .setAllowedOrigins(iWebSocketConfig.getCrossOrigins().toArray(new String[0]));
    }

    /**
     * 处理器
     *
     * @return 处理器
     */
    @Bean
    public WebSocketHandler webSocketHandler() {
        return new MyWebSocketHandler();
    }

}
