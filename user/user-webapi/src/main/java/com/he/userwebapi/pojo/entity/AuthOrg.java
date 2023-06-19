package com.he.userwebapi.pojo.entity;

import java.io.Serializable;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
/**
 * 组织表
 */
@Table(name = "auth_org")
public class AuthOrg implements Serializable {
    /**
     * id
     */
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    Long id;

    /**
     * 组织名称
     */
    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, isNull = false)
    String name;

    /**
     * 父级组织id
     */
    @Column(name = "parent_id", type = MySqlTypeConstant.BIGINT, isNull = false)
    Long parentId;

}
