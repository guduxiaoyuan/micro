package com.charlee.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author charlee
 * @date 2018/5/14
 */
@FeignClient(value = "cat-service", fallback = CatFeignFallback.class)
public interface CatFeign {

    @GetMapping("/hello/{name}")
    String hello(@PathVariable("name") String name);

}
