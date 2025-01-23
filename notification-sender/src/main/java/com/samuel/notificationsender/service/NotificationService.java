package com.samuel.notificationsender.service;


import entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private SmsServiceImpl smsService;

    public void setChannelNotification(Notification notification){
    }

}
