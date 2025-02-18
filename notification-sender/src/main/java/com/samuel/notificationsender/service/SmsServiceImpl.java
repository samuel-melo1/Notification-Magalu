package com.samuel.notificationsender.service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.samuel.notificationsender.interfaces.SenderService;
import entity.Notification;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SenderService {
    @Override
    public void send(Notification details) {
        Twilio.init("Username Twilio", "Password Twillio");
        Message.creator(new PhoneNumber(details.getDestination()), new PhoneNumber("Number Twilio"),
                        details.getMessage()).create();
    }
}
