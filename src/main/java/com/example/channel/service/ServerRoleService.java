package com.example.channel.service;

import com.example.channel.entity.ServerRoles;
import com.example.channel.repository.ServerRolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServerRoleService {
    private final ServerRolesRepository serverRolesRepository;

    public ServerRoles saveRole(ServerRoles role) {
        return serverRolesRepository.save(role);
    }

    public List<ServerRoles> getRolesByServer(String serverId) {
        return serverRolesRepository.findByServerId(serverId);
    }

    public void deleteRole(String id) {
        serverRolesRepository.deleteById(id);
    }
    public Optional<ServerRoles> findById(String id){
        return serverRolesRepository.findById(id);
    }
}
