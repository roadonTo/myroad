package com.road.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.road.utils.ConnectionUtil;

/**
 * 工作队列模式：发送消息
 */
public class Producer {
    /**
     * 1. 创建连接工厂（设置RabbitMQ的连接参数）；
     * 2. 创建连接；
     * 3. 创建频道；
     * 4. 声明队列；
     * 5. 发送消息；
     * 6. 关闭资源
     */
    static final String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws Exception {
        //创建连接
        Connection connection = ConnectionUtil.getConnection();
        //创建频道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
        //发送消息
        for (int i = 1; i <= 30; i++) {
            String message = "李嘉图，该赶飞机了---" + i;
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            System.out.println("已发送消息：" + message);
        }


        //关闭资源
        channel.close();
        connection.close();

    }

}
