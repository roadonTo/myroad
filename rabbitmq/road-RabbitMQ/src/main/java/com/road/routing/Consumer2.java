package com.road.routing;

import com.rabbitmq.client.*;
import com.road.utils.ConnectionUtil;

import java.io.IOException;

/**
 * 路由模式：接收消息
 */
public class Consumer2 {
    /*
        1. 创建连接
        2. 创建频道
        3. 声明交换机
        4. 声明队列
        5. 队列绑定到交换机
        6. 创建消费者
        7. 监听队列
     */
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(Producer.DIRECT_EXCHANGE, BuiltinExchangeType.DIRECT);

        channel.queueDeclare(Producer.DIRECT_QUEUE_2, true, false, false, null);

        channel.queueBind(Producer.DIRECT_QUEUE_2, Producer.DIRECT_EXCHANGE,"update");

        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("路由key为：" + envelope.getRoutingKey()
                        + "  交换机为：" + envelope.getExchange()
                        + "  消息id为：" + envelope.getDeliveryTag());
                System.out.println("消费者2--接收到的消息为：" + new String(body,"utf-8"));

            }
        };


        channel.basicConsume(Producer.DIRECT_QUEUE_2,true,defaultConsumer);


    }


}

