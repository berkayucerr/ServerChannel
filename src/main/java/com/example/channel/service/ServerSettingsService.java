package com.example.channel.service;

import com.example.channel.entity.ServerSettings;
import com.example.channel.repository.ServerSettingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServerSettingsService {

    private final ServerSettingsRepository serverSettingsRepository;

    public ServerSettings saveSetting(ServerSettings setting) {
        return serverSettingsRepository.save(setting);
    }

    public List<ServerSettings> getSettingsByServer(String serverId) {
        return serverSettingsRepository.findByServerId(serverId);
    }

    public ServerSettings getSetting(String serverId, String settingsKey) {
        return serverSettingsRepository.findByServerIdAndSettingsKey(serverId, settingsKey);
    }

    public void deleteSetting(String id) {
        serverSettingsRepository.deleteById(id);
    }

}
