package com.example.channel.repository;

import com.example.channel.entity.ChannelMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChannelMembersRepository extends JpaRepository<ChannelMember, String> {
    List<ChannelMember> findByChannelId(String channelId);

    void deleteByUserIdAndChannelId(String userId, String channelId);
}
