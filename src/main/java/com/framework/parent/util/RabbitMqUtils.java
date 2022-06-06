package com.framework.parent.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author luodong
 * @date 2022/5/13
 */
public class RabbitMqUtils {

    public static Channel getChannel() {
        ConnectionFactory consumerFactory = new ConnectionFactory();
        consumerFactory.setHost("127.0.0.1");
        consumerFactory.setUsername("admin");
        consumerFactory.setPassword("admin");

        Connection connection = null;
        Channel channel = null;
        try {
            connection = consumerFactory.newConnection();
            channel = connection.createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return channel;
    }
}
