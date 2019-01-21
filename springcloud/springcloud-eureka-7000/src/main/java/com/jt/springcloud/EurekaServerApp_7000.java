package com.jt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaServer			//定义为Eureka服务端
public class EurekaServerApp_7000 {
	
	public static void main(String[] args) {
		
		SpringApplication.run(EurekaServerApp_7000.class, args);
	}
}
