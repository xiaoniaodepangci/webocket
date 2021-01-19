package com.him.woll.singleservershiro.mapper;

import com.him.woll.singleservershiro.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huangc
 * @since 2021-01-19
 */
@Mapper
@Repository
public interface UsersMapper extends BaseMapper<Users> {

}
