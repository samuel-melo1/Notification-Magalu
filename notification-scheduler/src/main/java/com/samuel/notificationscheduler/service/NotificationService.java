package com.samuel.notificationscheduler.service;

import com.samuel.notificationscheduler.controller.dto.ScheduleNotificationDto;
import com.samuel.notificationscheduler.entity.Notification;
import com.samuel.notificationscheduler.enums.StatusEnum;

import com.samuel.notificationscheduler.repository.NotificationRepository;
import com.samuel.notificationscheduler.scheduler.MagaluTaskScheduler;
import config.RabbitMQConstantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;
@Service
public class NotificationService {

    private final NotificationRepository repository;
    private final RabbitTemplate rabbitTemplate;
    private static final Logger logger = LoggerFactory.getLogger(MagaluTaskScheduler.class);

    public NotificationService(NotificationRepository repository, RabbitTemplate rabbitTemplate) {
        this.repository = repository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void saveScheduleNotification(ScheduleNotificationDto dto){
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
    public void sendPendingNotifications(LocalDateTime dateTime){
       var notifications = repository.findByStatusInAndDateTimeBefore(Arrays.asList(
               StatusEnum.PENDENTE.toStatus(), StatusEnum.ERROR.toStatus()), dateTime);

       notifications.forEach(this::processNotification);
    }
    private void processNotification(Notification notification) {
        updateNotificationStatus(notification, sendToQueue(notification) ? StatusEnum.SUCCESS : StatusEnum.ERROR);
    }
    private boolean sendToQueue(Notification notification) {
        try{
            rabbitTemplate.convertAndSend(RabbitMQConstantes.EXG_NAME_NOTIFICATION,
                                          RabbitMQConstantes.RK_NOTIFICATION_LOG, notification);
            return true;
        }catch (AmqpException ex){
            logError(ex);
            return false;
        }
    }
    private void updateNotificationStatus(Notification notification, StatusEnum statusEnum) {
        notification.setStatus(statusEnum.toStatus());
        repository.save(notification);
    }
    private void logError(Exception e){
        logger.info(e.getMessage());
    }
}
