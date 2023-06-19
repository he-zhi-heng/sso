package com.he.userwebapi.pojo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

/**
 * 用户组织关联表
 */
@Table(name = "auth_user_org")
public class AuthUserOrgRel {
    /**
     * 用户id
     */
    @Column(name = "user_id",type = MySqlTypeConstant.BIGINT, isNull = false)
    Long userId;
    /**
     * 组织id
     */
    @Column(name = "org_id",type = MySqlTypeConstant.BIGINT,isNull = false)
    Long orgId;
    
}
