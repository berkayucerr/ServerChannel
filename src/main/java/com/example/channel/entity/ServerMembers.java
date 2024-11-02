package com.example.channel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ServerMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String serverId;
    private String userId;
    private String role;
    private String joinedAt;
    private String permissions;

}
