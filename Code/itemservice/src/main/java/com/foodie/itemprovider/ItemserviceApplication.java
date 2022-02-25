package com.foodie.itemprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @Author: fuke
 * @Date: 2021/6/9
 */
@MapperScan(basePackages = {"com.foodie.itemprovider.mapper"})
@SpringBootApplication
@EnableDiscoveryClient
public class ItemserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemserviceApplication.class, args);
	}

}
