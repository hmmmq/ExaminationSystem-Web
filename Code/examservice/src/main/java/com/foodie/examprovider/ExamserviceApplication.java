package com.foodie.examprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan(basePackages = {"com.foodie.examprovider.mapper"})
@SpringBootApplication
@EnableDiscoveryClient
public class ExamserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamserviceApplication.class, args);
	}

}
