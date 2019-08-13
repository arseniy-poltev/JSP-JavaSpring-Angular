/* 
 * Copyright 2018 onwards - Sunit Katkar (sunitkatkar@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tracking.system.security;

import com.tracking.system.user.permission.repository.PermissionRepository;
import com.tracking.system.user.permission.service.PermissionServiceImpl;
import com.tracking.system.user.permission.service.model.Permission;
import com.tracking.system.user.role.repository.RoleRepository;
import com.tracking.system.user.role.service.RoleServiceImpl;
import com.tracking.system.user.role.service.model.Role;
import com.tracking.system.user.service.UserService;
import com.tracking.system.user.service.UserServiceImpl;
import com.tracking.system.user.service.model.DetailUser;
import com.tracking.system.user.service.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    private UserServiceImpl userService;

    @Transactional
    @Override
    public DetailUser loadUserByUserName(String username) throws UsernameNotFoundException {
        if (StringUtils.isAnyBlank(username)) {
            throw new UsernameNotFoundException(
                    "Username and domain must be provided");
        }
        // Look for the user based on the username and tenant by accessing the
        // UserRepository via the UserService
        User user = userService.findByUserLoginName(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (user == null) {
//            throw new UsernameNotFoundException(
//                    String.format(
//                            "Username not found for domain, "
//                                    + "username=%s",
//                            username));
            return new DetailUser("","",grantedAuthorities,"","",0);
        }


        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new DetailUser(user.getLoginName(),user.getPassword(),grantedAuthorities,
                user.getType(),user.getCompanyName(),user.getCompanyId());
    }

}