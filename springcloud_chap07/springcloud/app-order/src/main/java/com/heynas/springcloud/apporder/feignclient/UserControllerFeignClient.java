package com.heynas.springcloud.apporder.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p> Description:  UserControllerFeignClient </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@FeignClient(name = "app-user",fallback = UserControllerFeignClientFallback.class)
public interface UserControllerFeignClient {
    @RequestMapping("/user/findById")
    String findById(@RequestParam("userId") String userId);
}
