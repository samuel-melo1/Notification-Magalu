package com.samuel.notificationsender.rabbitmq;

import com.samuel.notificationsender.interfaces.EmailService;
import entity.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import static config.RabbitMQConstantes.QUEUE_NOTIFICATION_LOG;
@Component
public class ConsumerNotification {
    @Autowired
    private EmailService service;
    @RabbitListener(queues = QUEUE_NOTIFICATION_LOG)
    public void receiveNotification(@Payload Notification fileBody){
        service.sendSimpleMail(fileBody);
    }
}
