package com.samuel.notificationscheduler.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.samuel.notificationscheduler.rabbitmq.RabbitMQConstantes.EXG_NAME_NOTIFICATION;
import static com.samuel.notificationscheduler.rabbitmq.RabbitMQConstantes.QUEUE_NOTIFICATION_LOG;
import static com.samuel.notificationscheduler.rabbitmq.RabbitMQConstantes.RK_NOTIFICATION_LOG;

@Configuration
public class RabbitmqConfig {
    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NOTIFICATION_LOG, false, false, false);
    }
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(EXG_NAME_NOTIFICATION, false, false);
    }
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(directExchange())
                .with(RK_NOTIFICATION_LOG);
    }
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
