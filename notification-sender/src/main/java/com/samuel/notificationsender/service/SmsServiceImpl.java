package com.samuel.notificationsender.service;

import com.samuel.notificationsender.interfaces.SenderService;
import entity.Notification;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SenderService {
    @Override
    public void send(Notification details) {

    }
}
