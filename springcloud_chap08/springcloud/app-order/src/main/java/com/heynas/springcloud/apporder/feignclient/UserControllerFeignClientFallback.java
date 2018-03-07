package com.heynas.springcloud.apporder.feignclient;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p> Description:  UserControllerFeignClientFallback </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@Component
public class UserControllerFeignClientFallback implements UserControllerFeignClient {
    @Override
    public String findById(@RequestParam("userId") String userId) {
        return "fallback";
    }
}
