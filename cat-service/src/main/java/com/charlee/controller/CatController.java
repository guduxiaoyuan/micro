package com.charlee.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author charlee
 * @date 2018/5/14
 */
@RestController
public class CatController {
    private static Logger log = LoggerFactory.getLogger(CatController.class);
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {

        log.info("真几拉力赛地方");
        return "hello, " + name;
    }
}
