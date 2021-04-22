package com.him.woll.singleservershiro.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.him.woll.singleservershiro.common.Result;
import com.him.woll.singleservershiro.entity.SysUser;
import com.him.woll.singleservershiro.mapper.SysUserMapper;
import com.him.woll.singleservershiro.shiro.kit.JwtUtil;
import com.him.woll.singleservershiro.shiro.kit.ShiroKit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 登录相关
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
public class SysLoginController {
    private final SysUserMapper userMapper;

    public SysLoginController(SysUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 登录
     *
     * @param sysUser 登录用户
     * @return 响应信息
     */
    @PostMapping("/sys/login")
    public Map<String, Object> login(@RequestBody SysUser sysUser) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount, sysUser.getAccount());
        SysUser usersDb = userMapper.selectOne(queryWrapper);

        //账号不存在、密码错误
        if (usersDb == null || !usersDb.getPassword().equals(ShiroKit.md5(sysUser.getPassword(), ""))) {
            return Result.error("账号或密码不正确");
        }
        Result result = new Result();
        result.put("accessToken", JwtUtil.createToken(sysUser.getAccount()));
        result.put("currUserInfo", usersDb);
        return result;
    }

    /**
     * token检测
     *
     * @param token jwt
     * @return 检测结果
     */
    @GetMapping("/token/check")
    public Result tokenCheck(String token) {
        Result result = new Result();
        result.put("check", JwtUtil.verify(token, JwtUtil.getUsername(token)));
        return result;
    }
}
