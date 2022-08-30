package com.javadev.webnewsMVC.services;

import com.javadev.webnewsMVC.entity.role.Role;
import com.javadev.webnewsMVC.entity.role.RoleName;

import java.util.Optional;

public interface IRoleServices {
    Optional<Role> findByRoleName(RoleName name);
}
