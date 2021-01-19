package com.him.woll.singleservershiro.shiro.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author CoolWen
 * @version 2018-11-01 8:30
 */
public class UrlPermission implements Permission {

    protected static final Logger logger = LoggerFactory.getLogger(UrlPermission.class);
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UrlPermission() {
    }

    public UrlPermission(String url) {
        this.url = url;
    }

    @Override
    public boolean implies(Permission p) {
        if (!(p instanceof UrlPermission)) return false;
        UrlPermission up = (UrlPermission) p;
        // /admin/user/*
        PatternMatcher patternMatcher = new AntPathMatcher();
        logger.debug(this.getUrl() + "," + up.getUrl() + "," + patternMatcher.matches(this.getUrl(), up.getUrl()));
        return patternMatcher.matches(this.getUrl(), up.getUrl());
    }
}
