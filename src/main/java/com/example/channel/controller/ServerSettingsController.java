package com.example.channel.controller;

import com.example.channel.entity.ServerSettings;
import com.example.channel.service.ServerSettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servers/{serverId}/settings")
@RequiredArgsConstructor
public class ServerSettingsController {

    private final ServerSettingsService serverSettingsService;


    @PostMapping
    public ResponseEntity<ServerSettings> saveSetting(@PathVariable String serverId, @RequestBody ServerSettings setting) {
        setting.setServerId(serverId);
        ServerSettings savedSetting = serverSettingsService.saveSetting(setting);
        return ResponseEntity.ok(savedSetting);
    }


    @GetMapping
    public ResponseEntity<List<ServerSettings>> getSettings(@PathVariable String serverId) {
        List<ServerSettings> settings = serverSettingsService.getSettingsByServer(serverId);
        return ResponseEntity.ok(settings);
    }


    @GetMapping("/{settingsKey}")
    public ResponseEntity<ServerSettings> getSetting(@PathVariable String serverId, @PathVariable String settingsKey) {
        ServerSettings setting = serverSettingsService.getSetting(serverId, settingsKey);
        return ResponseEntity.ok(setting);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSetting(@PathVariable String id) {
        serverSettingsService.deleteSetting(id);
        return ResponseEntity.noContent().build();
    }
}
