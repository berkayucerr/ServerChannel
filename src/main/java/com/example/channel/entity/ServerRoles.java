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
public class ServerRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String serverId;
    private String name;
    private String permissions;

}
