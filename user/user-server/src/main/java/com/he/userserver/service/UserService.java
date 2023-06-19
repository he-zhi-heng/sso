package com.he.userserver.service;

import com.he.pojo.vo.LoginUserVO;

public interface UserService {
    
    String login(LoginUserVO user);
    
}
