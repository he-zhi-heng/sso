package com.he.commons.exception;

import com.he.commons.enums.StateCode;
import lombok.Data;

/**
 * @author hemoren
 * 说明:
 * 这是一个基本的异常，包括一些基本的错误代码，或者包括一些具有指定标识符或字符的异常。
 */
@Data
public class BaseException extends RuntimeException{
    private StateCode code;
    public BaseException(StateCode code, String message) {
        super(message);
        setCode(code);
    }
}
