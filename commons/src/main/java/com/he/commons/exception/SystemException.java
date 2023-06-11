package com.he.commons.exception;

import com.he.commons.enums.StateCode;

/**
 * @author hemoren
 */
public class SystemException extends BaseException{
    public SystemException(StateCode code, String message) {
        super(code, message);
    }
}
