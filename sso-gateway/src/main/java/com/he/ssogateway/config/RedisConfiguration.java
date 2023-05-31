package com.he.ssogateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.io.Serializable;

/**
 * @author hemoren-Djava.home=/root/.cache/JetBrains/RemoteDev-IU/_home_lighthouse_project_sso/pid.825169.temp.jbr
 */
@Configuration
public class RedisConfiguration {
    /**
     * redisTemplate 序列化使用的jdk序列化方式
     * @param redisConnectionFactory redis连接
     * @return
     */
    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>(); // 创建redisTemplate
        redisTemplate.setConnectionFactory(redisConnectionFactory);  // 设置redis连接工厂
        redisTemplate.setKeySerializer(RedisSerializer.string());    // 设置key序列化方式
        redisTemplate.setValueSerializer(RedisSerializer.json());    // 设置value序列化方式
        return redisTemplate;
    }

}
