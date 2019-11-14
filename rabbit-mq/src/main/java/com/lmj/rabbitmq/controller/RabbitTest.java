package com.lmj.rabbitmq.controller;

import com.lmj.rabbitmq.sender.HelloSender;
import com.lmj.rabbitmq.sender.UserSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

    @Autowired
    private HelloSender helloSender1;

    @Autowired
    private UserSender helloSender2;

    /**
     * 单生产者-单消费者
     */
    @GetMapping("/hello")
    public void hello() {
        helloSender1.send("hello1");
    }

    /**
     * 单生产者-多消费者
     */
    @GetMapping("/oneToMany")
    public void oneToMany() {
        for (int i = 0; i < 4; i++) {
            helloSender1.send("第[" + (i + 1) + "]个 ---------> ");
        }
    }

    /**
     * 多生产者-多消费者
     */
    @GetMapping("/manyToMany")
    public void manyToMany() {
        for (int i = 0; i < 4; i++) {
            helloSender1.send("第[" + (i + 1) + "]个 ---------> ");
            helloSender2.send("第[" + (i + 1) + "]个 ---------> ");
        }

    }

}
