package com.framework.parent.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 消费者
 * @author luodong
 * @date 2022/5/13
 */
public class Consumer {

    public static  final String QUEUE_NAME= "hello";

    public static void main(String[] args) throws  Exception{

        // 创建链接工厂
        ConnectionFactory consumerFactory = new ConnectionFactory();
        consumerFactory.setHost("127.0.0.1");
        consumerFactory.setUsername("admin");
        consumerFactory.setPassword("admin");

        Connection connection = consumerFactory.newConnection();
        Channel channel = connection.createChannel();


        /**
         * String queue, boolean autoAck, String consumerTag, boolean noLocal, boolean exclusive, Map<String, Object> arguments, Consumer callback
         *
         * queue 消费的那个队列
         * autoAck 是否自动确认消息,true自动确认,false 不自动要手动调用,建立设置为false
         * consumerTag 消费者标签，用来区分多个消费者
         * noLocal 设置为true，表示 不能将同一个Conenction中生产者发送的消息传递给这个Connection中 的消费者
         * exclusive 是否排他
         * arguments 消费者的参数
         * callback 消费者 DefaultConsumer建立使用，重写其中的方法
         *     handleConsumeOk(String var1);
         *     handleCancelOk(String var1); 方法会在其它方法之前调用，返回消费者标签
         *     handleCancel(String var1) throws IOException;
         *     handleShutdownSignal(String var1, ShutdownSignalException var2);   当Channel与Conenction关闭的时候会调用
         *     handleRecoverOk(String var1);
         *     handleDelivery(String var1, Envelope var2, BasicProperties var3, byte[] var4) throws IOException;
         */

        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接收消息 :   " + new String(body));
            }
        };


        channel.basicConsume(QUEUE_NAME,defaultConsumer);
    }
}
