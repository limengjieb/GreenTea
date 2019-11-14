package com.lmj.rabbitmq.receiver;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class HelloRecever {

    @RabbitListener(queues = "hello")
    public void process(Message message, Channel channel) throws IOException {
        System.out.println("Receiver2 : " + new String(message.getBody()));
    }


}
