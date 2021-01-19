package com.him.woll.singleservershiro.shiro.config;



import com.him.woll.singleservershiro.shiro.filter.ResourceCheckFilter;
import com.him.woll.singleservershiro.shiro.permission.UrlPermissionResovler;
import com.him.woll.singleservershiro.shiro.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.filter.DelegatingFilterProxy;


import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public ResourceCheckFilter resourceCheckFilter() {
        ResourceCheckFilter resourceCheckFilter = new ResourceCheckFilter();
        resourceCheckFilter.setErrorUrl("405");
        return resourceCheckFilter;
    }


    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public FilterRegistrationBean delegatingFilterProxy() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        proxy.setTargetFilterLifecycle(true);
        proxy.setTargetBeanName("shiroFilter");
        filterRegistrationBean.setFilter(proxy);
        return filterRegistrationBean;
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public UrlPermissionResovler urlPermissionResovler() {
        return new UrlPermissionResovler();
    }

    @Bean(name = "shiroFilter")
    @DependsOn("lifecycleBeanPostProcessor")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());

        //添加内置过滤器

        /**
         *Shiro内置过滤器，
         * 常用过滤器
         * anon：无需认证可以访问
         * authc: 必须认证才能访问
         * user:如果使用remenmberMe 的功能可以直接访问
         * perms:该资源必须得到资源权限才能访问
         * role:该资源必须得到角色权限才能访问
         *
         * */

        Map<String, String> filterMap = new LinkedHashMap<String, String>();
        filterMap.put("/css/**", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/js/*/*/*", "anon");
        filterMap.put("/images/**", "anon");
        filterMap.put("/login", "anon");
        filterMap.put("/logout", "anon");
        filterMap.put("/ws", "anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");
        return shiroFilterFactoryBean;
    }

    /**
     * 创建    DefaultWebSecurityManager
     *
     * @return securityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {


        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        securityManager.setCacheManager(ehCacheManager());
        return securityManager;
    }


    @Bean("lifecycleBeanPostProcessor")
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public UserRealm userRealm() {
        UserRealm adminRealm = new UserRealm();
//        adminRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        adminRealm.setCacheManager(ehCacheManager());
        adminRealm.setCachingEnabled(true);
        adminRealm.setPermissionResolver(urlPermissionResovler());

        return adminRealm;
    }

    /**
     * 加密算法
     *
     * @return hashedCredentialsMatcher
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }



    /**
     * 缓存
     *
     * @return ehcache
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public EhCacheManager ehCacheManager() {

        EhCacheManager ehcache = new EhCacheManager();

        ehcache.setCacheManagerConfigFile("classpath:config/ehcache.xml");

        return ehcache;
    }


}
