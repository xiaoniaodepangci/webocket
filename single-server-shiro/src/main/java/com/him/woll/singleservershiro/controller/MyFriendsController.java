package com.him.woll.singleservershiro.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.him.woll.singleservershiro.common.Result;
import com.him.woll.singleservershiro.entity.MyFriends;
import com.him.woll.singleservershiro.entity.Users;
import com.him.woll.singleservershiro.mapper.MyFriendsMapper;
import com.him.woll.singleservershiro.mapper.UsersMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author huangc
 * @since 2021-01-19
 */
@RestController
@RequestMapping("/myFriends")
public class MyFriendsController {

    private final MyFriendsMapper myFriendsMapper;
    private final UsersMapper usersMapper;

    public MyFriendsController(MyFriendsMapper myFriendsMapper, UsersMapper usersMapper) {
        this.myFriendsMapper = myFriendsMapper;
        this.usersMapper = usersMapper;
    }

    /**
     * 获取好友名单
     *
     * @param principal 用户
     * @return 数据
     */
    @GetMapping("/")
    public Result getList(Principal principal) {
        Users users = (Users) SecurityUtils.getSubject().getPrincipal();
        LambdaQueryWrapper<Users> userQuery = new LambdaQueryWrapper<>();
//        userQuery.eq(Users::getUsername, users.getUsername());
//        Users users = usersMapper.selectOne(userQuery);

        LambdaQueryWrapper<MyFriends> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MyFriends::getMyUserId, users.getId());
        List<MyFriends> myFriends = myFriendsMapper.selectList(queryWrapper);
        List<String> friendIds = myFriends.stream().map(MyFriends::getMyFriendUserId).collect(Collectors.toList());

        userQuery.clear();
        userQuery.in(Users::getId, friendIds);
        List<Users> friends = new ArrayList<>();
        if (friendIds.size() != 0) {
            friends = usersMapper.selectList(userQuery);
        }
        return Result.ok().put("list", friends);
    }
}

