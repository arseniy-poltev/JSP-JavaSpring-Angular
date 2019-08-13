package com.tracking.config;

import com.tracking.system.company.service.CompanyServiceImpl;
import com.tracking.system.company.service.model.Company;
import com.tracking.system.user.permission.service.PermissionServiceImpl;
import com.tracking.system.user.permission.service.model.Permission;
import com.tracking.system.user.role.service.RoleServiceImpl;
import com.tracking.system.user.role.service.model.Role;
import com.tracking.system.user.service.UserServiceImpl;
import com.tracking.system.user.service.model.User;
import com.tracking.system.utils.GlobalConstant;
import com.tracking.system.utils.GlobalConstant.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Component
public class InitialDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PermissionServiceImpl permissionService;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    @Qualifier("passwordEncoder")
    private PasswordEncoder passwordEncoder;

    private Permission createPrivilegeIfNotFound(String name) {
        Permission permission = permissionService.findByName(name);
        if (permission == null) {
            permission = new Permission(name);
            permissionService.save(permission);
        }
        return permission;
    }

    private Role createRoleIfNotFound(
            String name, Collection<Permission> permissions) {
        Role role = roleService.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPermissions(permissions);
            roleService.save(role);
        }
        return role;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if(alreadySetup)
            return;
        //add permission
        Permission mgrPermission = createPrivilegeIfNotFound("PERMISSION_ADMIN_COMPANY_MGR");
        Permission clientPermission = createPrivilegeIfNotFound("PERMISSION_CLIENT_MGR");
        Permission userPermission = createPrivilegeIfNotFound("PERMISSION_ADMIN_COMPANY_MGR");
        //add role
        Role role_admin = createRoleIfNotFound("ROLE_ADMIN", Collections.singletonList(mgrPermission));
        Role role_client = createRoleIfNotFound("ROLE_CLIENT", Collections.singletonList(clientPermission));
        Role role_user = createRoleIfNotFound("ROLE_EMPLOYEE", new ArrayList<>());


        //add admin
        User admin1 = new User();
        admin1.setLoginName("admin");
        admin1.setPassword(passwordEncoder.encode("admin"));
        admin1.setEmail("admin@admin.com");
        admin1.setFirstName("Admin");
        admin1.setLastName("Super");
        admin1.setType(UserType.ADMIN.getValue());
        admin1.setRoles(Collections.singletonList(role_admin));


        User user = new User();
        user.setLoginName("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.setEmail("user@user.com");
        user.setFirstName("User");
        user.setLoginName("User");
        user.setType(UserType.EMPLOYEE.getValue());
        user.setRoles(Collections.singletonList(role_user));

        User client = new User();
        client.setLoginName("client");
        client.setPassword(passwordEncoder.encode("client"));
        client.setEmail("client@client.com");
        client.setFirstName("client");
        client.setLastName("client");
        client.setType(UserType.CLIENT.getValue());
        client.setRoles(Collections.singletonList(role_client));

        Company company = new Company();
        company.setInternalName("Google");
        company.setLegalName("Google LTD");
        company.setFantasyName("Google LTD");
        company.setBillingAddress("United States of America");
        company.setBillingEmail("google@google.com");
        company.setBillingId("19283727");
        company.setCountry("United States of America");
        company.setMainContactEmail("google@google.com");
        company.setOperationsEmail("google@google.com");

        for(int i=0;i<5;i++){
            User employee = new User();
            employee.setLoginName("Employee " + (i+1));
            employee.setPassword(passwordEncoder.encode("em1"));
            employee.setEmail("em1@em1.com");
            employee.setFirstName("Employee" + (i+1));
            employee.setLastName("Employee"+ (i+1));
            employee.setStatus(GlobalConstant.Status.ACTIVE.getValue());
            employee.setType(UserType.EMPLOYEE.getValue());
            employee.setRoles(Collections.singletonList(role_user));
            //----------testing code-----------
            employee.setCompanyId(1);
            //---------------------------------
            if(userService.findByUserLoginName(employee.getLoginName()) == null){
                userService.save(employee);
            }
        }

        if(companyService.findByInternalName(company.getInternalName()) == null){
            companyService.save(company);
        }
        if(userService.findByUserLoginName(admin1.getLoginName()) == null){
            userService.save(admin1);
        }


        if(userService.findByUserLoginName(user.getLoginName()) == null){
            userService.save(user);
        }


        if(userService.findByUserLoginName(client.getLoginName()) == null){
            client.setCompanyId((int)company.getId());
            userService.save(client);
        }



        alreadySetup = true;
    }
}
