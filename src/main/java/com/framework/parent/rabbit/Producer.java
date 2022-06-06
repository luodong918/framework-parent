package com.framework.parent.rabbit;

import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 生产者
 * @author luodong
 * @date 2022/5/13
 */
public class Producer {
    public static final  String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception{

        // 创建工厂
        ConnectionFactory rabbitFactory = new ConnectionFactory();
        rabbitFactory.setHost("127.0.0.1");
        rabbitFactory.setUsername("admin");
        rabbitFactory.setPassword("admin");

        // 创建一个链接
        Connection connection = rabbitFactory.newConnection();

        // 获取信道
        Channel channel = connection.createChannel();

        /**
         * String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
         *
         * 1. 队列名称
         * 2. 是否持久化到磁盘，默认是存储在内存
         * 3. 该队列是否只供一个消费者使用，是否需要消息共享 true 需要
         * 4. 是否自动进行删除
         * 5. 其他参数
         */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message  = "hello word";

        /**
         * String exchange, String routingKey, boolean mandatory, boolean immediate, BasicProperties props, byte[] body
         * 1. 交换机名称
         * 2. 队列名称
         * 3. 其他参数
         * 4. 消息体
         * 5.
         */
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("消息发送成功");
    }
}
