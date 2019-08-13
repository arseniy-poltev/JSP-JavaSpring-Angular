package com.tracking.system.user.role.service;

import com.tracking.system.user.role.service.model.Role;
import org.springframework.data.repository.query.Param;

public interface RoleService {
    Role findByName(@Param("name") String name);
    Role save(Role role);
}
