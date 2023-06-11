package com.he.commons.config;

import com.he.commons.log.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hemoren
 */
@Configuration
public class CommonConfig {

    /**
     *  Log Filter.
     *  注册日志过滤器
     * @return  Filter.
     */
    @Bean
    public FilterRegistrationBean<LogFilter> logFilterRegistration() {
        FilterRegistrationBean<LogFilter> registration = new FilterRegistrationBean<>();
        // 注入过滤器
        registration.setFilter(new LogFilter());
        // 拦截规则
        registration.addUrlPatterns("/*");
        // 过滤器名称
        registration.setName("logFilter");
        // 过滤器顺序
        registration.setOrder(0);
        return registration;
    }
}
