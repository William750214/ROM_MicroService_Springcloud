package com.heynas.springcloud.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.InetUtilsProperties;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import javax.inject.Inject;

@SpringBootApplication
@EnableEurekaServer
public class InfraDiscoveryApplication {
	public static void main(String[] args) {
		SpringApplication.run(InfraDiscoveryApplication.class, args);
	}
}
