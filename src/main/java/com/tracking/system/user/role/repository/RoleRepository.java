package com.tracking.system.user.role.repository;

import com.tracking.system.user.role.service.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByName(@Param("name") String name);
}
