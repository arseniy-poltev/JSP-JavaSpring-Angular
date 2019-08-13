package com.tracking.system.user.permission.service;

import com.tracking.system.user.permission.service.model.Permission;
import org.springframework.data.repository.query.Param;

public interface PermissionService {
    Permission findByName(@Param("name") String name);
    Permission save(Permission permission);
}
