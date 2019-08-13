/**
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
package com.tracking.web;

import com.tracking.system.user.service.model.DetailUser;
import com.tracking.system.utils.GlobalConstant;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tracking.system.utils.GlobalConstant.UserType;


@Controller
public class LoginController{

    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        GlobalConstant.getLoggedInUsername().ifPresent(f -> {
            model.addAttribute("userName", f);
        });

        return "index";
    }

    @Secured({"ROLE_CLIENT","ROLE_ADMIN"})
    @RequestMapping("/client/index")
    public String clientIndex(Model model) {
        GlobalConstant.getLoggedInUsername().ifPresent(f -> {
            model.addAttribute("userName", f);
        });
        return "client/index";
    }
    @GetMapping("/page2")
    public String page2() {
        return "page2";
    }

    @Secured({"ROLE_EMPLOYEE","ROLE_ADMIN"})
    @RequestMapping("/user/index")
    public String userIndex(Model model) {
        GlobalConstant.getLoggedInUsername().ifPresent(f -> {
            model.addAttribute("userName", f);
        });
        return "user/index";
    }

    @Secured({"ROLE_USER","ROLE_ADMIN","ROLE_CLIENT"})
    @RequestMapping("/main")
    public String mainIndex(Model model){
        DetailUser currentUser = getAuth();
        if(currentUser.getType().equals(UserType.ADMIN.getValue())){
            return "redirect:admin/index";
        }else if(currentUser.getType().equals(UserType.CLIENT.getValue())){
            return "redirect:client/index";
        }else{
            return "redirect:user/index";
        }
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    private DetailUser getAuth(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (DetailUser)auth.getPrincipal();
    }
}
