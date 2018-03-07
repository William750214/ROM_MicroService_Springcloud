package com.heynas.springcloud.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class InfraHystrixApplication {
	public static void main(String[] args) {
		SpringApplication.run(InfraHystrixApplication.class, args);
	}
}
