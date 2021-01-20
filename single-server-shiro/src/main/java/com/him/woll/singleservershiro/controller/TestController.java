package com.him.woll.singleservershiro.controller;

import com.him.woll.singleservershiro.common.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangc
 * @version 1.0
 * @date 21/01/20 16:24
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 权限测试1
     *
     * @return 权限测试1
     */
    @GetMapping("/per1")
    @RequiresPermissions("/test/per1")
    public R per1() {
        return R.ok("per1");
    }

    /**
     * 权限测试2
     *
     * @return 权限测试2
     */
    @GetMapping("/per2")
    @RequiresPermissions("/test/per2")
    public R per2() {
        return R.ok("per2");
    }
}
