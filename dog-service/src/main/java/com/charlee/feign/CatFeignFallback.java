package com.charlee.feign;

import org.springframework.stereotype.Component;

/**
 * @author charlee
 * @date 2018/5/14
 */
@Component
public class CatFeignFallback implements CatFeign {

    @Override
    public String hello(String name) {
        return "error";
    }
}
