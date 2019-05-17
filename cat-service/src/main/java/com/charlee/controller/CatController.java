package com.charlee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author charlee
 * @date 2018/5/14
 */
@RestController
public class CatController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "hello, " + name;
    }
}
