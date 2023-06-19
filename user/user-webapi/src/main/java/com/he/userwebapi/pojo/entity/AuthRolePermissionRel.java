package com.he.userwebapi.pojo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

@Table(name = "auth_role_permission")
public class AuthRolePermissionRel {
    /**
     * 角色id
     */
    @Column(name = "role_id",type = MySqlTypeConstant.BIGINT,isNull = false)
    Long roleId;

    /**
     * 权限id
     */
    @Column(name = "per_id",type = MySqlTypeConstant.BIGINT,isNull = false)
    Long permissionId;
}
