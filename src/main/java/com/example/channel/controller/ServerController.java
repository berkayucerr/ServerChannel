package com.example.channel.controller;

import com.example.channel.entity.Server;
import com.example.channel.service.ServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/servers")
@RequiredArgsConstructor
public class ServerController {

    private final ServerService serverService;

    @PostMapping
    public ResponseEntity<Server> createServer(@RequestBody Server server) {
        Server createdServer = serverService.createServer(server.getName(), server.getDescription(), server.getOwnerId());
        return ResponseEntity.ok(createdServer);
    }

    @DeleteMapping("/{serverId}")
    public ResponseEntity<Void> deleteServer(@PathVariable String serverId) {
        serverService.deleteServer(serverId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{serverId}/members")
    public ResponseEntity<Void> addUserToServer(@PathVariable String serverId, @RequestParam String userId) {
        serverService.addUserToServer(serverId, userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{serverId}/members")
    public ResponseEntity<Void> removeUserFromServer(@PathVariable String serverId, @RequestParam String userId) {
        serverService.removeUserFromServer(serverId, userId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{serverId}/roles/{roleId}/permissions")
    public ResponseEntity<Void> setRolePermissions(
            @PathVariable String serverId,
            @PathVariable String roleId,
            @RequestBody Map<String, Boolean> permissions) {
        serverService.setRolePermissions(serverId, roleId, permissions);
        return ResponseEntity.ok().build();
    }
}

