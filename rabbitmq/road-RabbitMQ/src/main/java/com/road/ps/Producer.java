package com.road.ps;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.road.utils.ConnectionUtil;

/**
 * 发布与订阅模式：发送消息
 *
 */
public class Producer {
/*
    1. 创建连接
    2. 创建频道
    3. 声明交换机
    4. 声明队列
    5. 队列绑定到交换机
    6. 发送消息
    7. 关闭资源
 */
    //交换机名称
    static final String FANOUT_EXCHANGE = "fanout_exchange";
    //队列名称
    static final String FANOUT_QUEUE_1 = "fanout_queue_1";
    //队列名称
    static final String FANOUT_QUEUE_2 = "fanout_queue_2";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare(FANOUT_EXCHANGE, BuiltinExchangeType.FANOUT);
        //声明队列
        channel.queueDeclare(FANOUT_QUEUE_1,true,false,false,null);
        channel.queueDeclare(FANOUT_QUEUE_2,true,false,false,null);
        //队列绑定到交换机
        channel.queueBind(FANOUT_QUEUE_1,FANOUT_EXCHANGE,"");
        channel.queueBind(FANOUT_QUEUE_2,FANOUT_EXCHANGE,"");

        for (int i = 1; i < 30; i++) {
            String message = "hello sakura---" + i ;
            channel.basicPublish(FANOUT_EXCHANGE,"",null,message.getBytes());
            System.out.println("已发送消息：" + message);
        }

        channel.close();
        connection.close();

    }


}
