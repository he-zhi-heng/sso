package com.he.commons.enums;

import lombok.Data;

/**
 * @author hemoren
 */

public enum StateCode {
    /**
     * 成功
     */
    SUCCESS(20000),
    /**
     * 请求参数错误
     */
    BAD_REQUEST(40000),

    /**
     * 参数不合法
     */
    BAD_PARAMETER(40001),

    /**
     * 操作不可用
     */
    NOT_SUPPORTED(40002),

    /**
     * 操作有误
     */
    INTERNAL_ERROR(40003),

    /**
     * 参数不可用
     */
    BAD_PARAMETER_VALUE(40004),
    /**
     *  jwt
     */
    ERR_JWT_EXPIRED(40005),
    /**
     * JWT 格式不正确
     */
    ERR_JWT_MALFORMED(40006), 
    /**
     * JWT 签名错误
     */
    ERR_JWT_SIGNATURE(40007), 

    /**
     * 服务器异常
     */
    SERVER_ERROR(50000);

    private final Integer value;

    StateCode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
