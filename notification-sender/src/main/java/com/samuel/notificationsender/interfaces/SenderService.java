package com.samuel.notificationsender.interfaces;

import entity.Notification;

public interface SenderService {
    void send(Notification details);
}
