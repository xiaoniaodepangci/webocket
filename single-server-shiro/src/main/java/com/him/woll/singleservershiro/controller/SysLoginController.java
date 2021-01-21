

package com.him.woll.singleservershiro.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.him.woll.singleservershiro.common.Result;
import com.him.woll.singleservershiro.entity.Users;
import com.him.woll.singleservershiro.mapper.UsersMapper;
import com.him.woll.singleservershiro.shiro.kit.JwtUtil;
import com.him.woll.singleservershiro.shiro.kit.ShiroKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

/**
 * 登录相关
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
public class SysLoginController {
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 登录
     */
    @PostMapping("/sys/login")
    public Map<String, Object> login(@RequestBody Users users) throws IOException {
        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Users::getUsername, users.getUsername());
        Users usersDb = usersMapper.selectOne(queryWrapper);

        //账号不存在、密码错误
        if (usersDb == null || !usersDb.getPassword().equals(ShiroKit.md5(users.getPassword(), ""))) {
            return Result.error("账号或密码不正确");
        }
        Result result = new Result();
        result.put("accessToken", JwtUtil.createToken(users.getUsername()));
        return result;
    }


}
