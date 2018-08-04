package com.darvasr.movies.service;

import com.darvasr.movies.entity.Role;
import com.darvasr.movies.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;


    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }

    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }
}
