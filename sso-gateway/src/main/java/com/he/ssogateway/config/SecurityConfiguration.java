package com.he.ssogateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;



/**
 * @author root
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置登录请求相关内容。
        http.formLogin()
                .loginPage("/toLogin") // 当用户未登录的时候，跳转的登录页面地址是什么？ 默认 /login
                .usernameParameter("username") // 设置请求参数中，用户名参数名称。 默认username
                .passwordParameter("password") // 设置请求参数中，密码参数名称。 默认password
//                .loginProcessingUrl("/login") //设置登录 提交表单数据访问请求地址
//                .defaultSuccessUrl("/toMain")
                .failureUrl("/toLogin")
                // TODO  登录成功后的跳转路径需要能够灵活修改, 根据用户想要访问的服务url进行修改
                .successHandler(new MyAuthenticationSuccessHandler("/toMain", true)) //自定义登录成功处理器
                .failureHandler(new MyAuthenticationFailureHandler("/toLogin", true));

        http.authorizeRequests()
                //.antMatchers("/toLogin").anonymous() //只能匿名用户访问
                .antMatchers("/toLogin", "/register", "/login", "/favicon.ico").permitAll() // /toLogin请求地址，可以随便访问。
                .antMatchers("/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/userInfo/reg/**",
                        "/v2/api-docs/**").permitAll() // 授予所有目录下的所有.css文件可访问权限
                .anyRequest().authenticated(); // 任意的请求，都必须认证后才能访问。

        // 配置退出登录
        http.logout()
                .invalidateHttpSession(true) // 回收HttpSession对象。退出之前调用HttpSession.invalidate() 默认 true
                .clearAuthentication(true) // 退出之前，清空Security记录的用户登录标记。 默认 true
                // .addLogoutHandler() // 增加退出处理器
                .logoutSuccessUrl("/") // 配置退出后，进入的请求地址。 默认是loginPage?logout
                .logoutUrl("/logout"); // 配置退出登录的路径地址。和页面请求地址一致即可。

        // 关闭CSRF安全协议。
        // 关闭是为了保证完整流程的可用。

        http.csrf().disable();
    }



    /**
     * 加密
     * @return 加密对象
     * 如需使用自定义密码凭证匹配器 返回自定义加密对象
     * 例如: return new MD5PasswordEncoder();
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//        return new SCryptPasswordEncoder();
        //int saltLength, int hashLength, int parallelism, int memory, int iterations
        //创建时可以传入参数,
        return new Argon2PasswordEncoder();
//        return new MyMD5PasswordEncoder(); //Spring Security 自带
    }
}
