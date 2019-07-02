package com.charlee.kafka.messageReceive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaohy on 2019/6/26.
 */
@RestController
@RequestMapping("/kafka")
public class SendController {
    @Autowired
    private Producer producer;

    @RequestMapping(value = "/send")
    public String send() {
        producer.send();
        return "{\"code\":0}";
    }

}
