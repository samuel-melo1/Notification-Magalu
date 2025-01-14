package com.samuel.notificationscheduler.service;

import com.samuel.notificationscheduler.controller.dto.ScheduleNotificationDto;
import com.samuel.notificationscheduler.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public void scheduleNotification(ScheduleNotificationDto dto){
        repository.save(dto.toNotification());
    }
}
