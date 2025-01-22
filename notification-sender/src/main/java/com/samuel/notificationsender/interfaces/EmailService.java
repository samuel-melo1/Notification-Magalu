package com.samuel.notificationsender.interfaces;

import com.samuel.notificationsender.entity.Email;
import entity.Notification;

public interface EmailService {

    void sendSimpleMail(Notification details);
}
