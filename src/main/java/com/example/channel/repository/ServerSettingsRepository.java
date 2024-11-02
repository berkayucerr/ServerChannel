package com.example.channel.repository;

import com.example.channel.entity.ServerSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerSettingsRepository extends JpaRepository<ServerSettings,String> {
}
