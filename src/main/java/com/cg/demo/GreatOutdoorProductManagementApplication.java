package com.cg.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
//@EnableDiscoveryClient
@EnableSwagger2
public class GreatOutdoorProductManagementApplication{
	public static void main(String[] args) {
	SpringApplication.run(GreatOutdoorProductManagementApplication.class, args);
	
}

}