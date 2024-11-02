package com.example.channel.repository;

import com.example.channel.entity.ServerRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRolesRepository extends JpaRepository<ServerRoles,String> {
}
