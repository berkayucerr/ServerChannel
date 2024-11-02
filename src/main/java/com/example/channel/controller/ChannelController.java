package com.example.channel.controller;

import com.example.channel.entity.Channel;
import com.example.channel.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servers/{serverId}/channels")
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;

    @PostMapping
    public ResponseEntity<Channel> createChannel(@PathVariable String serverId, @RequestParam String name, @RequestParam String type) {
        Channel newChannel = channelService.createChannel(serverId, name, type);
        return ResponseEntity.ok(newChannel);
    }

    @DeleteMapping("/{channelId}")
    public ResponseEntity<Void> deleteChannel(@PathVariable String serverId, @PathVariable String channelId) {
        channelService.deleteChannel(channelId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Channel>> getChannels(@PathVariable String serverId) {
        List<Channel> channels = channelService.getChannelsByServer(serverId);
        return ResponseEntity.ok(channels);
    }

    @GetMapping("/{channelId}")
    public ResponseEntity<Channel> getChannel(@PathVariable String serverId, @PathVariable String channelId) {
        Channel channel = channelService.getChannelById(channelId);
        return ResponseEntity.ok(channel);
    }

    @PutMapping("/{channelId}")
    public ResponseEntity<Channel> updateChannel(@PathVariable String serverId, @PathVariable String channelId, @RequestParam String name, @RequestParam String type) {
        Channel updatedChannel = channelService.updateChannel(channelId, name, type);
        return ResponseEntity.ok(updatedChannel);
    }
}

