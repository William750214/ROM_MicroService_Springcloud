package com.heynas.springcloud.appuser.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/add")
    public String add() {
        return "zhangsan " + UUID.randomUUID().toString();
    }

    @RequestMapping("/findByPk")
    public String findByPk() {
        return UUID.randomUUID().toString();
    }
}
