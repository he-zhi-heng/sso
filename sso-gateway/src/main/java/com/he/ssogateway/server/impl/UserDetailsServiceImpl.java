package com.he.ssogateway.server.impl;

import com.github.pagehelper.PageInfo;
import com.he.commons.result.JsonPage;
import com.he.commons.result.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author hemoren
 */
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //数据库中根据用户名查询用户信息
        // 如果不存在则抛出异常
        //如果存在则将用户信息,权限信息封装入user, 并返回

        return User.builder().username("")
                .password("")
                .authorities(new ArrayList<>())
                .build();

    }

    public JsonResult<String> a(String username) throws UsernameNotFoundException {
        return JsonResult.ok();
    }
}
