package com.example.channel.service;

import com.example.channel.entity.ChannelMember;
import com.example.channel.repository.ChannelMembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChannelMembersService {

    private final ChannelMembersRepository repository;

    public void joinChannel(String userId, String channelId) {
        ChannelMember channelMember = new ChannelMember();
        channelMember.setUserId(userId);
        channelMember.setChannelId(channelId);
        repository.save(channelMember);
    }

    public List<ChannelMember> getUsersOfChannel(String channelId) {
        return repository.findByChannelId(channelId);
    }

    public void leaveFromChannel(String userId, String channelId) {
        repository.deleteByUserIdAndChannelId(userId, channelId);
    }
}
