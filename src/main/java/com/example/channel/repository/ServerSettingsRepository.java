package com.example.channel.repository;

import com.example.channel.entity.ServerSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerSettingsRepository extends JpaRepository<ServerSettings,String> {
    List<ServerSettings> findByServerId(String serverId); // Sunucu ID'sine göre ayarları bul
    ServerSettings findByServerIdAndSettingsKey(String serverId, String settingsKey); // Belirli bir anahtara göre ayarı bul

}
