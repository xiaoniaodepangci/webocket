package com.him.woll.singleservershiro.websocket.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 配置信息类
 *
 * @author huangc
 * @version 1.0
 * @date 21/01/08 16:16
 */
@Configuration
@Component
@ConfigurationProperties(prefix = "websocket")
public class IWebSocketConfig {

    /**
     * 端口
     */
    private String endpoint;

    /**
     * 可跨域名单
     */
    private List<String> crossOrigins;

    /**
     * 认证凭据的标志位
     */
    private String certificateSign;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public List<String> getCrossOrigins() {
        return crossOrigins;
    }

    public void setCrossOrigins(List<String> crossOrigins) {
        this.crossOrigins = crossOrigins;
    }

    public String getCertificateSign() {
        return certificateSign;
    }

    public void setCertificateSign(String certificateSign) {
        this.certificateSign = certificateSign;
    }
}
