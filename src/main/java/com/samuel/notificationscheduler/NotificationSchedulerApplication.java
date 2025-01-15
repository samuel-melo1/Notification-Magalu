package com.samuel.notificationscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NotificationSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationSchedulerApplication.class, args);
    }

}
