package com.samuel.notificationscheduler.repository;

import com.samuel.notificationscheduler.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
