package com.he.userwebapi.pojo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

/**
 * 用户角色关联表
 */
@Table(name = "auth_user_role")
public class AuthUserRoleRel {
    /**
     * 用户id
     */
    @Column(name = "user_id",type = MySqlTypeConstant.BIGINT,isNull = false)
    Long userId;

    /**
     * 角色id
     */
    @Column(name = "rol_id",type = MySqlTypeConstant.BIGINT,isNull = false)
    Long roleId;
}
