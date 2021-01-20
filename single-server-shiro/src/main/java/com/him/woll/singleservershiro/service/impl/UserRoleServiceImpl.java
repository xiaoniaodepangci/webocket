package com.him.woll.singleservershiro.service.impl;

import com.him.woll.singleservershiro.entity.UserRole;
import com.him.woll.singleservershiro.mapper.UserRoleMapper;
import com.him.woll.singleservershiro.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author huangc
 * @since 2021-01-20
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
