package com.example.channel.controller;

import com.example.channel.entity.ServerRoles;
import com.example.channel.service.ServerRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servers/{serverId}/roles")
@RequiredArgsConstructor
public class ServerRolesController {

    private final ServerRoleService serverRoleService;

    @PostMapping
    public ResponseEntity<ServerRoles> createRole(@PathVariable String serverId, @RequestBody ServerRoles role) {
        role.setServerId(serverId);
        ServerRoles createdRole = serverRoleService.saveRole(role);
        return ResponseEntity.ok(createdRole);
    }

    @GetMapping
    public ResponseEntity<List<ServerRoles>> getRolesByServer(@PathVariable String serverId) {
        List<ServerRoles> roles = serverRoleService.getRolesByServer(serverId);
        return ResponseEntity.ok(roles);
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<String> deleteRole(@PathVariable String roleId, @PathVariable String serverId) {
        serverRoleService.deleteRole(roleId);
        return ResponseEntity.noContent().build();
    }
}

