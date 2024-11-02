package com.example.channel.repository;

import com.example.channel.entity.ServerRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerRolesRepository extends JpaRepository<ServerRoles,String> {
    List<ServerRoles> findByServerId(String serverId); // Sunucu ID'sine göre rolleri bul

}
