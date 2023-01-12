package com.road.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.road.utils.ConnectionUtil;

/**
 * 通配符模式：发送消息
 *
 */
public class Producer {
    /*
        1. 创建连接
        2. 创建频道
        3. 声明交换机

        6. 发送消息
        7. 关闭资源
     */
    //交换机名称
    static final String TOPIC_EXCHANGE = "topic_exchange";

    //队列名称
    static final String TOPIC_QUEUE_1 = "topic_queue_insert";
    //队列名称
    static final String TOPIC_QUEUE_2 = "topic_queue_update";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare(TOPIC_EXCHANGE, BuiltinExchangeType.TOPIC);


        //发送三条信息
        String message = "hello 李嘉图---" ;
        channel.basicPublish(TOPIC_EXCHANGE,"item.insert",null,message.getBytes());
        System.out.println("已发送消息：" + message);

        message = "hello 芬格尔---" ;
        channel.basicPublish(TOPIC_EXCHANGE,"item.update",null,message.getBytes());
        System.out.println("已发送消息：" + message);

        message = "hello 凯撒---" ;
        channel.basicPublish(TOPIC_EXCHANGE,"item.delete",null,message.getBytes());
        System.out.println("已发送消息：" + message);


        channel.close();
        connection.close();

    }


}
