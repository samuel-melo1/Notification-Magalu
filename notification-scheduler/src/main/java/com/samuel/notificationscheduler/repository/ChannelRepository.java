package com.samuel.notificationscheduler.repository;

import com.samuel.notificationscheduler.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
