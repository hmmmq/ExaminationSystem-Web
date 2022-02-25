package com.foodie.examconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
public class ExamconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamconsumerApplication.class, args);
	}

}
