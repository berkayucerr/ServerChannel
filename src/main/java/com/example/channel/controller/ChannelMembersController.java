package com.example.channel.controller;

import com.example.channel.entity.ChannelMember;
import com.example.channel.service.ChannelMembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/channelMembers")
@RequiredArgsConstructor
public class ChannelMembersController {
    private final ChannelMembersService service;

    @PostMapping
    public void joinIntoChannel(@RequestParam String userId, @RequestParam String channelId) {
        service.joinChannel(userId, channelId);
    }

    @GetMapping
    public List<ChannelMember> getUserList(@RequestParam String channelId) {
        return service.getUsersOfChannel(channelId);
    }

    @PostMapping("/leave")
    public void leaveFromChannel(@RequestParam String userId, @RequestParam String channelId) {
        service.leaveFromChannel(userId, channelId);
    }

}
