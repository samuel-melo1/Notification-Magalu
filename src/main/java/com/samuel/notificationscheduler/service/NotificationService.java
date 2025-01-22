package com.samuel.notificationscheduler.service;

import com.samuel.notificationscheduler.controller.dto.ScheduleNotificationDto;
import com.samuel.notificationscheduler.entity.Notification;
import com.samuel.notificationscheduler.enums.StatusEnum;
import com.samuel.notificationscheduler.rabbitmq.RabbitMQConstantes;
import com.samuel.notificationscheduler.repository.NotificationRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {

    private final NotificationRepository repository;
    private final RabbitTemplate rabbitTemplate;

    public NotificationService(NotificationRepository repository, RabbitTemplate rabbitTemplate) {
        this.repository = repository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void scheduleNotification(ScheduleNotificationDto dto){
        repository.save(dto.toNotification());
    }
    public Optional<Notification> findById(Long notificationId){
        return repository.findById(notificationId);
    }

    public void cancelNotification(Long notificationId){
       var notification = findById(notificationId);

       if(notification.isPresent()){
           notification.get().setStatus(StatusEnum.CANCELED.toStatus());
           repository.save(notification.get());
       }
    }
    public void checkAndSend(LocalDateTime dateTime){
       var notifications = repository.findByStatusInAndDateTimeBefore(List.of(
               StatusEnum.PENDENTE.toStatus(), StatusEnum.ERROR.toStatus()), dateTime);

       notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return notification -> {
            rabbitTemplate.convertAndSend(RabbitMQConstantes.EXG_NAME_NOTIFICATION, RabbitMQConstantes.RK_NOTIFICATION_LOG, notification);
            notification.setStatus(StatusEnum.SUCCESS.toStatus());
            repository.save(notification);
        };
    }
}
