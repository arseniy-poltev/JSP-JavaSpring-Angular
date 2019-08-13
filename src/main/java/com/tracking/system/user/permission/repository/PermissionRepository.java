package com.tracking.system.user.permission.repository;

import com.tracking.system.user.permission.service.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PermissionRepository extends JpaRepository<Permission, String> {
    Permission findByName(@Param("name") String name);
}
