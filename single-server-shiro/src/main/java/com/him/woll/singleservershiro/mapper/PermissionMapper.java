package com.him.woll.singleservershiro.mapper;

import com.him.woll.singleservershiro.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author huangc
 * @since 2021-01-20
 */
@Mapper
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {

}
