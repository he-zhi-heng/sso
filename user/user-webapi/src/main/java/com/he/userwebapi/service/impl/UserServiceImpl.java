package com.he.userwebapi.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import com.he.pojo.dto.LoginUserDTO;
import com.he.pojo.vo.SimpleUserVO;
import com.he.userserver.service.UserService;
import com.he.userwebapi.mapper.UserMapper;

@Service
@DubboService
public class UserServiceImpl implements UserService{

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String login(LoginUserDTO user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SimpleUserVO getUserInfo(String username) {
        // TODO Auto-generated method stub
        return userMapper.getUserInfoByUsername(username);
    }


}
