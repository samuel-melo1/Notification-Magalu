package com.samuel.notificationscheduler.service;

import com.samuel.notificationscheduler.controller.dto.ScheduleNotificationDto;
import com.samuel.notificationscheduler.entity.Notification;
import com.samuel.notificationscheduler.enums.StatusEnum;
import com.samuel.notificationscheduler.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {

    private NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
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

    private  Consumer<Notification> sendNotification() {
        return n -> {
            // Realizar o envio da notificação

            n.setStatus(StatusEnum.SUCCESS.toStatus());
            repository.save(n);
        };
    }
}
