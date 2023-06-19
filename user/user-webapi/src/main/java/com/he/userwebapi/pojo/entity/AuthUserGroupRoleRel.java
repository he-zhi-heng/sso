package com.he.userwebapi.pojo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

@Table(name = "auth_user_group_role")
public class AuthUserGroupRoleRel {
    /**
     *  用户组id
     */
    @Column(name = "user_group_id",type = MySqlTypeConstant.BIGINT,isNull = false)
    Long userGroupId;

    /**
     * 角色id
     */

    @Column(name = "role_id",type = MySqlTypeConstant.BIGINT,isNull = false)
    Long roleId;
    
}
