package com.lmj.rabbitmq.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class UserSender {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg) {
        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sendMsg = msg + time.format(new Date()) + " hello2 ";
        System.out.println("Sender2 : " + sendMsg);
        this.rabbitTemplate.convertAndSend("hello", sendMsg);
    }

}
