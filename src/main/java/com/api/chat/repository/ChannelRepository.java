package com.api.chat.repository;

import com.api.chat.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ChannelRepository extends JpaRepository<Channel, Long> {
    Channel findChannelById(Long channelId);

    @Query("SELECT uc.channel FROM UserChannel uc  WHERE uc.user.id = :userId")
    List<Channel> findChannelsByUserId(@Param("userId") Long userId);

    @Query("SELECT uc.channel FROM UserChannel uc  WHERE uc.user.id = :userId AND uc.channel.id = :channelId")
    Channel findChannelByIdAndUserId(@Param("channelId") Long channelId, @Param("userId") Long userId);

}
