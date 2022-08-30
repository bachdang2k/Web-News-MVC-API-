package com.javadev.webnewsMVC.services.Impl;

import com.javadev.webnewsMVC.entity.role.Role;
import com.javadev.webnewsMVC.entity.role.RoleName;
import com.javadev.webnewsMVC.repository.IRoleRepository;
import com.javadev.webnewsMVC.services.IRoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleServices {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Optional<Role> findByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
