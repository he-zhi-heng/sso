package com.he.userwebapi.pojo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

/**
 * 职位角色关联表
 */
@Table(name = "auth_position_role")
public class AuthPositionRoleRel {
    /**
     * 职位id
     */
    @Column(name = "position_id",type = MySqlTypeConstant.BIGINT,isNull = false)
    Long positionId;

    /**
     * 角色id
     */

    @Column(name = "role_id",type = MySqlTypeConstant.BIGINT,isNull = false)
    Long  roleId;

}
