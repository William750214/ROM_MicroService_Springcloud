package com.heynas.springcloud.apporder.controller;

import com.heynas.springcloud.apporder.feignclient.UserControllerFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p> Description:  StudentController </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController implements EnvironmentAware{
    private static Map ORDER_MAP = new ConcurrentHashMap();

    private static Environment environment;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserControllerFeignClient userControllerFeignClient;

    @RequestMapping("/add")
//    @HystrixCommand(fallbackMethod = "addFallback")
    public String add(String userId, String orderId, String orderName) {
//        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
//        requestEntity.add("userId", userId);

//        String userName = restTemplate.postForObject(
//                "http://localhost:9091/user/findById", requestEntity, String.class);

//        String userName = restTemplate.postForObject(
//                "http://APP-USER/user/findById", requestEntity, String.class);

        String userName = userControllerFeignClient.findById(userId);

        orderName = userName + " 's " + orderName;

        ORDER_MAP.put(orderId, orderName);

        System.out.println(OrderController.environment.getProperty("eureka.instance.metadata-map.key02"));

        return orderId + " " + orderName + " " + UUID.randomUUID().toString();
    }

    public String addFallback(String userId, String orderId, String orderName) {
        return "888";
    }

    @Override
    public void setEnvironment(Environment environment) {
        OrderController.environment = environment;
    }
}
