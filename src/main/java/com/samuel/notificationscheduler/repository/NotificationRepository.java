package com.samuel.notificationscheduler.repository;

import com.samuel.notificationscheduler.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
