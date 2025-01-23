package com.samuel.notificationsender;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationSenderApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationSenderApplication.class, args);


        Twilio.init("", "");

        Message.creator(
                        new PhoneNumber(""),
                        new PhoneNumber(""),
                        "teste")
                .create();
    }
}
