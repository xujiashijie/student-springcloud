package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@MapperScan("com.jt.springcloud.mapper")
@EnableEurekaClient
@EnableHystrix	
public class SpringCloud_Provider {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringCloud_Provider.class, args);
	}
	
}
