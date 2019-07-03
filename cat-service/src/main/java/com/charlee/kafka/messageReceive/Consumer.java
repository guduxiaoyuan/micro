package com.charlee.kafka.messageReceive;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by zhaohy on 2019/6/26.
 * 消费者
 */
@Component
public class Consumer {
    @KafkaListener(topics = {"test"},groupId = "xiaofeng1")
    public void listen(ConsumerRecord<?, ?> record){

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
//            System.out.println("---->"+record);
            System.out.println("消费者1---->"+message);
        }

    }

}
