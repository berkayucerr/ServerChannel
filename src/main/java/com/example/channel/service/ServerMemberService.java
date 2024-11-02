package com.example.channel.service;

import com.example.channel.entity.ServerMembers;
import com.example.channel.repository.ServerMembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServerMemberService {
    private final ServerMembersRepository serverMembersRepository;

    public ServerMembers addMember(String serverId, String userId) {
        ServerMembers member = new ServerMembers();
        member.setServerId(serverId);
        member.setUserId(userId);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        member.setJoinedAt(timestamp);
        return serverMembersRepository.save(member);
    }

    public void removeMember(String serverId, String userId) {
        serverMembersRepository.deleteByServerIdAndUserId(serverId, userId);
    }

    public List<ServerMembers> getMembersByServer(String serverId) {
        return serverMembersRepository.findByServerId(serverId);
    }

    public boolean isUserMember(String serverId, String userId) {
        return serverMembersRepository.existsByServerIdAndUserId(serverId, userId);
    }

    public long countMembers(String serverId) {
        return serverMembersRepository.countByServerId(serverId);
    }
}
