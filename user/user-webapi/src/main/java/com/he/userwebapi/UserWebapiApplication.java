package com.he.userwebapi;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableDubbo
public class UserWebapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserWebapiApplication.class, args);
	}

}
