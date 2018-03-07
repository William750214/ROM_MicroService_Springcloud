package com.heynas.springcloud.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class AppUserApplication {
    @Autowired
    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(AppUserApplication.class, args);
    }

    @RequestMapping("/app-user-meta")
    public List getAppUserMeta() {
        return this.discoveryClient.getInstances("app-user");
    }

    @RequestMapping("/app-order-meta")
    public List getAppOrderMeta() {
        return this.discoveryClient.getInstances("app-order");
    }
}
