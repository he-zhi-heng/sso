package com.he.commons.exception;

import com.he.commons.enums.StateCode;

/**
 * @author hemoren
 */
public class UtilsException extends BaseException{
    public UtilsException(StateCode code, String message) {
        super(code, message);
    }
}
