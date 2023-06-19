package com.he.userserver.service;

import com.he.pojo.dto.LoginUserDTO;
import com.he.pojo.vo.SimpleUserVO;

public interface UserService {
    
    String login(LoginUserDTO user);

    SimpleUserVO getUserInfo(String username);
    
}
