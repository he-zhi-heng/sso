package com.he.userwebapi.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.he.pojo.vo.SimpleUserVO;
import com.he.userwebapi.pojo.entity.AuthUser;

@Mapper
public interface UserMapper {

    /**
     * 
     * @param user
     * @return
     */
    int save(AuthUser user);

    SimpleUserVO getUserInfoByUsername(String username);

}
