package com.javadev.webnewsMVC.repository;

import com.javadev.webnewsMVC.entity.role.Role;
import com.javadev.webnewsMVC.entity.role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(RoleName roleName);
}
