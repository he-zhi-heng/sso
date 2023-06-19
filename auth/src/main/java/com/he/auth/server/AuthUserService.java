package com.he.auth.server;

import com.he.pojo.dto.LoginUserDTO;

public interface AuthUserService {
    
    /**
     * 用户登录验证
     */
    String validateUser(LoginUserDTO user);
}
