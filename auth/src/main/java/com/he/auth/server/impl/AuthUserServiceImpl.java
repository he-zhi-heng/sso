package com.he.auth.server.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import com.he.auth.server.AuthUserService;
import com.he.pojo.dto.LoginUserDTO;
import com.he.pojo.vo.SimpleUserVO;
import com.he.userserver.service.UserService;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    @DubboReference
    private UserService userservice;

    @Override
    public String validateUser(LoginUserDTO user) {
        // TODO Auto-generated method stub
        String username = user.getUsername();
        SimpleUserVO userVO = userservice.getUserInfo(username);
        
        return null;
    }

}
