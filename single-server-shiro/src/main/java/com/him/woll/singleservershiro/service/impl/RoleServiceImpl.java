package com.him.woll.singleservershiro.service.impl;

import com.him.woll.singleservershiro.entity.Role;
import com.him.woll.singleservershiro.mapper.RoleMapper;
import com.him.woll.singleservershiro.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author huangc
 * @since 2021-01-20
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
