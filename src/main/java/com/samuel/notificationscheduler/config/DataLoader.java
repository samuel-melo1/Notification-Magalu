package com.samuel.notificationscheduler.config;

import com.samuel.notificationscheduler.entity.Channel;
import com.samuel.notificationscheduler.enums.ChannelEnum;
import com.samuel.notificationscheduler.repository.ChannelRepository;
import com.samuel.notificationscheduler.repository.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {
    private final ChannelRepository channelRepository;
    private final StatusRepository statusRepository;
    public DataLoader(ChannelRepository channelRepository, StatusRepository statusRepository) {
        this.channelRepository = channelRepository;
        this.statusRepository = statusRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(ChannelEnum.values())
                .map(ChannelEnum::toChannel)
                .forEach(channelRepository::save);
    }
}
