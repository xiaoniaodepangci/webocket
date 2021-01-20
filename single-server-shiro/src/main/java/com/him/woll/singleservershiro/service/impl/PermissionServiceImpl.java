package com.him.woll.singleservershiro.service.impl;

import com.him.woll.singleservershiro.entity.Permission;
import com.him.woll.singleservershiro.mapper.PermissionMapper;
import com.him.woll.singleservershiro.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author huangc
 * @since 2021-01-20
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
