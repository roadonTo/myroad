package com.road.simple;

import com.rabbitmq.client.*;
import com.road.utils.ConnectionUtil;

import java.io.IOException;

/**
 * 简单模式；消费者接收消息
 */
public class Consumer {
/**
 * 1. 创建连接工厂；
 * 2. 创建连接；（抽取一个获取连接的工具类）
 * 3. 创建频道；
 * 4. 声明队列；
 * 5. 创建消费者（接收消息并处理消息）；
 * 6. 监听队列（因为需要持续监听队列消息，所以不要关闭资源）
 */

    public static void main(String[] args) throws Exception {

        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(Producer.QUEUE_NAME,true,false,false,null);

        //创建消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("路由key为：" + envelope.getRoutingKey()
                        + "  交换机为：" + envelope.getExchange()
                        + "  消息id为：" + envelope.getDeliveryTag());
                System.out.println("接收到的消息为：" + new String(body,"utf-8"));
            }
        };

        //监听队列
        channel.basicConsume(Producer.QUEUE_NAME,true,defaultConsumer);


    }

}
