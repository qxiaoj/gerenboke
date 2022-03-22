package com.qj.mapper;

import com.qj.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qxiaoj
 * @since 2022-03-22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过用户名查询
     * @param username
     * @return
     */
    User getByUserName(String username);
}
