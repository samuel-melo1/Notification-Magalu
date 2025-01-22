package com.samuel.notificationsender.service;

import com.samuel.notificationsender.entity.Email;
import com.samuel.notificationsender.interfaces.EmailService;
import entity.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
    @Override
    public void sendSimpleMail(Notification notification) {
        try {
            javaMailSender.send(createMailMessage(notification));
        }
        catch (Exception e) {
            logError(e);
        }
    }
    private SimpleMailMessage createMailMessage(Notification notification){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo(notification.getDestination());
        mailMessage.setText(notification.getMessage());
        mailMessage.setSubject("Email Validation!");
        return mailMessage;
    }
    private void logError(Exception e){
        logger.info(e.getMessage());
    }
}
