package com.samuel.notificationscheduler.repository;

import com.samuel.notificationscheduler.entity.Notification;
import com.samuel.notificationscheduler.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
