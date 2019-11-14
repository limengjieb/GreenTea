package com.lmj.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {


    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue userQueue() {
        return new Queue("user");
    }

    @Bean
    TopicExchange topicExchange () {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeHello(Queue helloQueue,TopicExchange topicExchange) {
        return BindingBuilder.bind(helloQueue).to(topicExchange).with("hello");
    }

    @Bean
    Binding bindingExchangeUser(Queue userQueue,TopicExchange topicExchange) {
        return BindingBuilder.bind(userQueue).to(topicExchange).with("user");
    }

    @Bean
    public RabbitTemplate rabbitTemplateNew(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return rabbitTemplate;
    }
}
