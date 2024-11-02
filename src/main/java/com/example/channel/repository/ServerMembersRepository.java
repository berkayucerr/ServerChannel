package com.example.channel.repository;

import com.example.channel.entity.ServerMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerMembersRepository extends JpaRepository<ServerMembers,String> {
}
