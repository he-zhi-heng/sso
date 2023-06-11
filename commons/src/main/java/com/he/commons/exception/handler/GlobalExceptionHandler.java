package com.he.commons.exception.handler;

import com.he.commons.enums.StateCode;
import com.he.commons.exception.BaseException;
import com.he.commons.result.JsonResult;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * @author hemoren
 */
@RestControllerAdvice
@Data
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理业务异常
     */
    @ExceptionHandler({BaseException.class})
    public JsonResult<Void> handleCoolSharkServiceException(BaseException e) {
        log.debug("出现业务异常，业务错误码={}，描述文本={}", e.getCode().getValue(), e.getMessage());
        e.printStackTrace();
        JsonResult<Void> result = JsonResult.failed(e);
        log.debug("即将返回：{}", result);
        return result;
    }

    /**
     * 处理绑定异常（通过Validation框架验证请求参数时的异常）
     */
    @ExceptionHandler(BindException.class)
    public JsonResult<Void> handleBindException(BindException e) {
        log.debug("验证请求数据时出现异常：{}", e.getClass().getName());
        e.printStackTrace();
        String message = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        JsonResult<Void> result = JsonResult.failed(StateCode.BAD_REQUEST, message);
        log.debug("即将返回：{}", result);
        return result;
    }

    /**
     * 处理系统（其它）异常
     */
    @ExceptionHandler({Throwable.class})
    public JsonResult<Void> handleSystemError(Throwable e) {
        log.debug("出现系统异常，异常类型={}，描述文本={}", e.getClass().getName(), e.getMessage());
        e.printStackTrace();
        JsonResult<Void> result = JsonResult.failed(StateCode.SERVER_ERROR, e);
        log.debug("即将返回：{}", result);
        return result;
    }
}
