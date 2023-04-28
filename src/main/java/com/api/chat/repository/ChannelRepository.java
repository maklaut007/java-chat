package com.api.chat.repository;

import com.api.chat.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChannelRepository extends JpaRepository<Channel, Long> {
    Channel findChannelById(Long channelId);
}
