package com.charlee.controller;

import com.charlee.feign.CatFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author charlee
 * @date 2018/5/14
 */
@RestController
public class DogController {

    private final CatFeign catFeign;

    public DogController(CatFeign catFeign) {
        this.catFeign = catFeign;
    }

    @GetMapping("/test/{username}")
    public String hello(@PathVariable String username) {
        return catFeign.hello(username);
    }

}
