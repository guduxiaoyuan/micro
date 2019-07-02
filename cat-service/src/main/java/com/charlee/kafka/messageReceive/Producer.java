package com.charlee.kafka.messageReceive;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by zhaohy on 2019/6/26.
 * 提供者
 */
@Component
public class Producer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    private static Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send() {
        MessageDemo demo = new MessageDemo();
        demo.setTaskId("12");
        demo.setTaskName("任务名称");
        demo.setExId("1");
        demo.setStatus("状态");
        kafkaTemplate.send("test", gson.toJson(demo));
    }

}
