package com.he.userwebapi.pojo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

/**
 * 权限表
 */
@Table(name = "auth_permission")
public class AuthPermission {
    /**
     * id
     */
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    Long id;

    /**
     * 权限名称
     */

    @Column(name = "per_name", type = MySqlTypeConstant.VARCHAR, isNull = false)
    String perName;

    /**
     * 权限类型
     */
    @Column(name = "per_type", type = MySqlTypeConstant.VARCHAR, isNull = false)
    String perType;

    /**
     * 父级权限id
     */
    @Column(name = "parent_id", type = MySqlTypeConstant.BIGINT, isNull = false)
    Long parentId;

}
