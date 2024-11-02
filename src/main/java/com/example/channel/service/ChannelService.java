package com.example.channel.service;

import com.example.channel.entity.Channel;
import com.example.channel.repository.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChannelService {
    private final ChannelRepository channelRepository;

    public Channel createChannel(String serverId, String name, String type) {
        Channel channel = new Channel();
        channel.setServerId(serverId);
        channel.setType(type);
        channel.setName(name);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        channel.setCreatedAt(timestamp);
        return channelRepository.save(channel);
    }

    public void deleteChannel(String channelId) {
        channelRepository.deleteById(channelId);
    }

    public List<Channel> getChannelsByServer(String serverId) {
        return channelRepository.findByServerId(serverId);
    }

    public Channel updateChannel(String channelId, String name, String type) {
        Channel channel = channelRepository.findById(channelId).orElseThrow(() -> new RuntimeException("Channel not found"));
        channel.setName(name);
        channel.setType(type);
        return channelRepository.save(channel);
    }

    public Channel getChannelById(String channelId) {
        return channelRepository.findById(channelId).orElseThrow(() -> new RuntimeException("Channel not found"));
    }

}
