package com.road.work;

import com.rabbitmq.client.*;
import com.road.utils.ConnectionUtil;

import java.io.IOException;

/**
 * 工作模式；消费者接收消息
 */
public class Consumer1 {
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
        final Channel channel = connection.createChannel();
        channel.queueDeclare(Producer.QUEUE_NAME,true,false,false,null);

        channel.basicQos(1);

        //创建消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    System.out.println("路由key为：" + envelope.getRoutingKey()
                            + "  交换机为：" + envelope.getExchange()
                            + "  消息id为：" + envelope.getDeliveryTag());
                    System.out.println("消费者1--接收到的消息为：" + new String(body,"utf-8"));

                    Thread.sleep(2000);

                    //确认消息，参数1：消息id     参数2：false表示只有当前这条被处理
                    channel.basicAck(envelope.getDeliveryTag(),false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        //监听队列
        channel.basicConsume(Producer.QUEUE_NAME,true,defaultConsumer);


    }

}
