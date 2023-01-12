package com.road.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    @RabbitListener(queues = "item_queue")
    public void myListener(String message){
        System.out.println("消费者接收到消息：" + message);
    }

}
