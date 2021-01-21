package com.him.woll.singleservershiro.shiro.realm;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.him.woll.singleservershiro.entity.Permission;
import com.him.woll.singleservershiro.entity.RolePermission;
import com.him.woll.singleservershiro.entity.UserRole;
import com.him.woll.singleservershiro.entity.Users;
import com.him.woll.singleservershiro.mapper.PermissionMapper;
import com.him.woll.singleservershiro.mapper.RolePermissionMapper;
import com.him.woll.singleservershiro.mapper.UserRoleMapper;
import com.him.woll.singleservershiro.mapper.UsersMapper;
import com.him.woll.singleservershiro.shiro.kit.JwtUtil;
import com.him.woll.singleservershiro.shiro.token.JwtToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Slf4j
public class JwtRealm extends AuthorizingRealm {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 身份认证
     *
     * @param authenticationToken token
     * @return 已认证信息
     * @throws AuthenticationException authenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) authenticationToken;
        String username = JwtUtil.getUsername(jwtToken.getPrincipal());

        //获取用户名，默认和login.html中的adminName对应。
        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Users::getUsername, username);
        Users users = usersMapper.selectOne(queryWrapper);

        if (users == null) {
            //没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
            throw new UnknownAccountException("用户不存在！");
        }

        //验证通过返回一个封装了用户信息的AuthenticationInfo实例即可。
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                users,
                jwtToken.getPrincipal(),
                getName()
        );
        return authenticationInfo;
    }


    /**
     * 授权认证
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("————权限认证————");
        String username = JwtUtil.getUsername(principals.toString());

        // 查用户
        LambdaQueryWrapper<Users> userQueryWrapper = new LambdaQueryWrapper<>();
        userQueryWrapper.eq(Users::getUsername, username);
        Users users = usersMapper.selectOne(userQueryWrapper);

        // 查角色
        LambdaQueryWrapper<UserRole> userRoleQuery = new LambdaQueryWrapper<>();
        userRoleQuery.eq(UserRole::getUserId, users.getId());
        List<UserRole> roles = userRoleMapper.selectList(userRoleQuery);
        // 全部角色
        List<String> roleStrings = roles.stream().map(UserRole::getRoleId).collect(Collectors.toList());

        // 查角色权限中间表
        LambdaQueryWrapper<RolePermission> rolePermissionQuery = new LambdaQueryWrapper<>();
        rolePermissionQuery.in(RolePermission::getRoleId, roleStrings);
        List<RolePermission> rolePermissions = rolePermissionMapper.selectList(rolePermissionQuery);
        // 所有权限id
        List<String> perStr = rolePermissions.stream().map(RolePermission::getPermissionId).collect(Collectors.toList());
        LambdaQueryWrapper<Permission> permissionQuery = new LambdaQueryWrapper<>();
        permissionQuery.in(Permission::getId, perStr);
        List<Permission> permissions = permissionMapper.selectList(permissionQuery);
        // 全部权限字符串
        List<String> per = permissions.stream().map(Permission::getPermission).collect(Collectors.toList());

        Set<String> allPermissions = new HashSet<>(per);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(allPermissions);
        return info;
    }
}
