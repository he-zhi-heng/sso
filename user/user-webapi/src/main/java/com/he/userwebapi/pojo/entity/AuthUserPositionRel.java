package com.he.userwebapi.pojo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

/**
 * 用户职位关联表
 */
@Table(name = "auth_user_position")
public class AuthUserPositionRel {
    /**
     * 用户id
     */
    @Column(name = "user_id", type = MySqlTypeConstant.BIGINT, isNull = false)
    Long userId;

    /**
     * 职位id
     */
    @Column(name = "position_id", type = MySqlTypeConstant.BIGINT, isNull = false)
    Long positionId;

}
