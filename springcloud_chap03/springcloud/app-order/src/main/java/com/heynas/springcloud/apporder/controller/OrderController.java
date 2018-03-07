package com.heynas.springcloud.apporder.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
public class OrderController {
    private static Map ORDER_MAP = new ConcurrentHashMap();

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/add")
    public String add(String userId, String orderId, String orderName) {
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("userId", userId);

//        String userName = restTemplate.postForObject(
//                "http://localhost:9091/user/findById", requestEntity, String.class);

        String userName = restTemplate.postForObject(
                "http://APP-USER/user/findById", requestEntity, String.class);

        orderName = userName + " 's " + orderName;

        ORDER_MAP.put(orderId, orderName);

        return orderId + " " + orderName + " " + UUID.randomUUID().toString();
    }
}
