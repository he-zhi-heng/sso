package com.he.userwebapi.pojo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

/**
 * 用户组表
 */
@Table(name = "auth_user_group")
public class AuthUserGroup {
    /**
     * id
     */
    @Column(name = "id", type = MySqlTypeConstant.BIGINT,isKey = true)
    Long id;

    /**
     * 用户组名称
     */

    @Column(name = "name", type = MySqlTypeConstant.VARCHAR,isNull = false)
    String name;
    
}
