package com.lmj.rabbitmq.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChannelConfig {

    @Bean
    public Channel getChannel() throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);

        // 创建一个连接
        Connection connection = connectionFactory.newConnection();

        // 创建一个频道
        Channel channel = connection.createChannel();
        return channel;
    }



}
