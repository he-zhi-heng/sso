package com.he.userwebapi.pojo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

/**
 * 角色表
 */
@Table(name = "auth_role")
public class AuthRole {
    /**
     * id
     */
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    Long id;

    /**
     * 角色名称
     */

    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, length = 64, isNull = false)
    String name;

    /**
     * 父级角色id
     */
    @Column(name = "parent_id", type = MySqlTypeConstant.BIGINT, isNull = false)
    Long parentId;

}
