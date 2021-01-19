package com.him.woll.singleservershiro.shiro.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
@Slf4j
public class ResourceCheckFilter extends AccessControlFilter {

    private String errorUrl;
    public String getErrorUrl() {
        return errorUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object o) throws Exception {

        Subject subject = getSubject(request, response);

        String url = getPathWithinApplication(request);

        System.out.println("当前访问路径:" + url);

        return subject.isPermitted(url);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletResponse hsp = (HttpServletResponse) response;
        HttpServletRequest hReq = (HttpServletRequest) request;

        System.out.println(hReq.getContextPath() + this.errorUrl);

        String url = getPathWithinApplication(request);
        System.out.println("当前访问路径:" + url);
        hsp.sendRedirect(hReq.getContextPath() + "/" + this.errorUrl);
        System.out.println("重定向路径:" + hReq.getContextPath());
        System.out.println("错误路径:" + errorUrl);
        System.out.println("ResourceCheckFilter-----------------权限拒绝");
        return false;

    }
}
