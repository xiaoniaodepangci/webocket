package com.him.woll.singleservershiro.service.impl;

import com.him.woll.singleservershiro.entity.Users;
import com.him.woll.singleservershiro.mapper.UsersMapper;
import com.him.woll.singleservershiro.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangc
 * @since 2021-01-19
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
