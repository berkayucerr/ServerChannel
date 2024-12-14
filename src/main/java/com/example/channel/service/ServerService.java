package com.example.channel.service;

import com.example.channel.entity.Server;
import com.example.channel.entity.ServerRoles;
import com.example.channel.repository.ServerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ServerService {
    private final ServerRepository serverRepository;
    private final ServerMemberService serverMemberService;
    private final ServerRoleService serverRoleService;
    public Server createServer(String name, String description, String ownerId) {
        Server server = new Server();
        server.setOwnerId(ownerId);
        server.setName(name);
        server.setDescription(description);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        server.setCreatedAt(timestamp);
        return serverRepository.save(server);
    }

    public void deleteServer(String serverId) {
        serverRepository.deleteById(serverId);

    }

    public void addUserToServer(String serverId, String userId) {
        serverMemberService.addMember(serverId,userId);
    }

    public void removeUserFromServer(String serverId, String userId) {
        serverMemberService.removeMember(serverId,userId);
    }

    private String convertPermissionsToJson(Map<String, Boolean> permissions) {

        StringBuilder jsonBuilder = new StringBuilder("{");
        permissions.forEach((key, value) -> jsonBuilder.append("\"").append(key).append("\":").append(value).append(","));

        if (jsonBuilder.length() > 1) {
            jsonBuilder.setLength(jsonBuilder.length() - 1);
        }
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

    public void setRolePermissions(String serverId, String roleId, Map<String, Boolean> permissions) {

        ServerRoles role = serverRoleService.findById(roleId)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));

        String permissionsJson = convertPermissionsToJson(permissions);
        role.setPermissions(permissionsJson);
        role.setServerId(serverId);
        serverRoleService.saveRole(role);
    }

    public Server findServerById(String serverId) {
        return serverRepository.findById(serverId).orElseThrow(() -> new RuntimeException("Server could not find"));
    }

    public List<Server> findAll() {
        return serverRepository.findAll();
    }
}
