package com.he.auth.server.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.he.pojo.vo.SimpleUserVO;
import com.he.userserver.service.UserService;
/**
 * 当客户端提交登录后，会自动调用UserDetailsService接口（Spring Security定义的）的实现类对象中的UserDetailsloadUserByUsername(String username)方法（根据用户名加载用户数据），将得到UserDetails类型的对象，此对象中应该至少包括此用户名对应的密码、权限等信息，接下来，Spring Security会自动完成密码的对比，并确定此次客户端提交的信息是否允许登录！ 
 */

@Service
public class UserDetailServcieImp implements UserDetailsService{
    
    @DubboReference
    private UserService userservice;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        SimpleUserVO userVO = userservice.getUserInfo(username);
        
        return null;
    }
    
}
