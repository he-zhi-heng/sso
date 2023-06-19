package com.he.userwebapi.pojo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
/**
 * 职位表
 */
@Table(name = "auth_position")
public class AuthPosition {
    /**
     * id
     */
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    Long id;

    /**
     * 职位名称
     */
    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, isNull = false)
    String name;

    /**
     * 父级职位id
     */
    @Column(name = "parent_id", type = MySqlTypeConstant.BIGINT, isNull = false)
    Long parentId;

}
