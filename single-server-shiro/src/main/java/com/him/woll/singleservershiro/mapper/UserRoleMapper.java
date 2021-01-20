package com.him.woll.singleservershiro.mapper;

import com.him.woll.singleservershiro.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户角色表 Mapper 接口
 * </p>
 *
 * @author huangc
 * @since 2021-01-20
 */
@Mapper
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
