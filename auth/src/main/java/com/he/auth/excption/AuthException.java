package com.he.auth.excption;

import com.he.commons.enums.StateCode;
import com.he.commons.exception.BaseException;

/**
 * @author hemoren
 */
public class AuthException extends BaseException {
    public AuthException(StateCode code, String message) {
        super(code, message);
    }
}
