package com.him.woll.singleservershiro.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.him.woll.singleservershiro.common.Result;
import com.him.woll.singleservershiro.entity.ImUserRelationship;
import com.him.woll.singleservershiro.entity.SysUser;
import com.him.woll.singleservershiro.mapper.ImUserRelationshipMapper;
import com.him.woll.singleservershiro.mapper.SysUserMapper;
import org.apache.shiro.SecurityUtils;
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

    private final ImUserRelationshipMapper userRelationshipMapper;
    private final SysUserMapper userMapper;

    public MyFriendsController(ImUserRelationshipMapper userRelationshipMapper,
                               SysUserMapper userMapper) {
        this.userRelationshipMapper = userRelationshipMapper;
        this.userMapper = userMapper;
    }

    /**
     * 获取好友名单
     *
     * @param principal 用户
     * @return 数据
     */
    @GetMapping("/")
    public Result getList(Principal principal) {
        SysUser users = (SysUser) SecurityUtils.getSubject().getPrincipal();
        LambdaQueryWrapper<ImUserRelationship> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ImUserRelationship::getMyUserId, users.getUserId());
        List<ImUserRelationship> myFriends = userRelationshipMapper.selectList(queryWrapper);
        List<String> friendIds = myFriends.stream().map(ImUserRelationship::getFriendId).collect(Collectors.toList());

        LambdaQueryWrapper<SysUser> userQuery = new LambdaQueryWrapper<>();
        userQuery.clear();
        userQuery.in(SysUser::getUserId, friendIds);
        List<SysUser> friends = new ArrayList<>();
        if (friendIds.size() != 0) {
            friends = userMapper.selectList(userQuery);
            friends.forEach(item -> item.setPassword(""));
        }
        return Result.ok().put("list", friends);
    }
}

