package com.him.woll.singleservershiro.shiro.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 自定义token类
 *
 * @author huangc
 * @version 1.0
 * @date 21/01/20 11:40
 */
public class JwtToken implements AuthenticationToken {

    private final String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
