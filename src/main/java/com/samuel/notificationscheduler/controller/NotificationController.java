package com.samuel.notificationscheduler.controller;

import com.samuel.notificationscheduler.controller.dto.ScheduleNotificationDto;
import com.samuel.notificationscheduler.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> postScheduleNotifications(@RequestBody ScheduleNotificationDto dto){
        this.notificationService.scheduleNotification(dto);

        return ResponseEntity.accepted().build();
    }

}
