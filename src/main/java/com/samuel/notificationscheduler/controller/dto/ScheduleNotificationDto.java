package com.samuel.notificationscheduler.controller.dto;

import com.samuel.notificationscheduler.entity.Channel;
import com.samuel.notificationscheduler.entity.Notification;
import com.samuel.notificationscheduler.enums.ChannelEnum;
import com.samuel.notificationscheduler.enums.StatusEnum;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(LocalDateTime dateTime,
                                      String destination,
                                      String message,
                                      ChannelEnum channel) {

    public Notification toNotification(){
        return new Notification(
          dateTime, destination, message, channel.toChannel(), StatusEnum.PENDENTE.toStatus()
        );
    }
}
