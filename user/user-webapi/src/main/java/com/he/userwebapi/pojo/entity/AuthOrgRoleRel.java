package com.he.userwebapi.pojo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

/**
 * 组织角色关联表
 */
@Table(name = "auth_org_role")
public class AuthOrgRoleRel {
    /**
     * 组织id
     */
    @Column(name = "org_id", type = MySqlTypeConstant.BIGINT, isNull = false)
    Long orgId;

    /**
     * 角色id
     */
    @Column(name = "rol_id", type = MySqlTypeConstant.BIGINT, isNull = false)
    Long  roleId;
}
