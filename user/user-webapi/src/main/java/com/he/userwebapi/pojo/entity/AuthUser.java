package com.he.userwebapi.pojo.entity;

import java.io.Serializable;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

/**
 * 用户表
 */
@Table(name = "auth_user")
public class AuthUser implements Serializable {
    /**
     * 用户id
     */
    @Column(name = "id",type = MySqlTypeConstant.BIGINT,isKey = true)
    Long id;

    /**
     * 用户名
     */
    @Column(name = "username",type = MySqlTypeConstant.VARCHAR,length = 25,isNull = false)
    String username;

}
