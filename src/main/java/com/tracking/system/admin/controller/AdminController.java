package com.tracking.system.admin.controller;

import com.tracking.system.company.controller.CompanyController;
import com.tracking.system.company.service.CompanyService;
import com.tracking.system.company.service.CompanyServiceImpl;
import com.tracking.system.utils.GlobalConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    CompanyServiceImpl companyService;

    @Secured("ROLE_ADMIN")
    @RequestMapping("/admin/index")
    public String adminIndex(Model model) {

        GlobalConstant.getLoggedInUsername().ifPresent(f -> {
            model.addAttribute("userName", f);
            model.addAttribute("companies",companyService.findAll());
        });
        return "admin/index";
    }


}
