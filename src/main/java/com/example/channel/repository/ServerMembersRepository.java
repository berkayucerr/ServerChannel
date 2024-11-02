package com.example.channel.repository;

import com.example.channel.entity.ServerMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerMembersRepository extends JpaRepository<ServerMembers, String> {
    void deleteByServerIdAndUserId(String serverId, String userId);

    List<ServerMembers> findByServerId(String serverId);

    boolean existsByServerIdAndUserId(String serverId, String userId);

    long countByServerId(String serverId);
}
