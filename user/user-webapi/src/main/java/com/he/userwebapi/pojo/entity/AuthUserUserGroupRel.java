package com.he.userwebapi.pojo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

/**
 * 用户用户组关联表
 */
@Table(name = "auth_user_user_gruop")
public class AuthUserUserGroupRel {
    /**
     * 用户id
     */
    @Column(name = "user_id",type = MySqlTypeConstant.BIGINT,isNull = false)
    Long userId;

    /**
     * 用户组id
     */

    @Column(name = "group_id",type = MySqlTypeConstant.BIGINT,isNull = false)
    Long userGroupId;
}
