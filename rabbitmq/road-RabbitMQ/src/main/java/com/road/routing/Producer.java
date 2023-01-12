package com.road.routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.road.utils.ConnectionUtil;

/**
 * 路由模式：发送消息
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
    static final String DIRECT_EXCHANGE = "direct_exchange";
    //队列名称
    static final String DIRECT_QUEUE_1 = "direct_queue_insert";
    //队列名称
    static final String DIRECT_QUEUE_2 = "direct_queue_update";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare(DIRECT_EXCHANGE, BuiltinExchangeType.DIRECT);
        //声明队列
        channel.queueDeclare(DIRECT_QUEUE_1,true,false,false,null);
        channel.queueDeclare(DIRECT_QUEUE_2,true,false,false,null);
        //队列绑定到交换机
        channel.queueBind(DIRECT_QUEUE_1,DIRECT_EXCHANGE,"insert");
        channel.queueBind(DIRECT_QUEUE_2,DIRECT_EXCHANGE,"update");

        //发送两条信息
        String message1 = "hello sakura---" ;
        channel.basicPublish(DIRECT_EXCHANGE,"insert",null,message1.getBytes());
        System.out.println("已发送消息：" + message1);

        String message2 = "hello 芬格尔---" ;
        channel.basicPublish(DIRECT_EXCHANGE,"update",null,message2.getBytes());
        System.out.println("已发送消息：" + message2);


        channel.close();
        connection.close();

    }


}
