package com.tracking.system.user.permission.service;

import com.tracking.system.user.permission.repository.PermissionRepository;
import com.tracking.system.user.permission.service.model.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
    private static final Logger LOG = LoggerFactory
            .getLogger(PermissionServiceImpl.class);

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Permission findByName(String name) {
        return permissionRepository.findByName(name);
    }

    @Override
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }
}
