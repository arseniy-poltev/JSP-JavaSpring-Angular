package com.tracking.system.company.contract.controller;

import com.tracking.response.Response;
import com.tracking.system.company.contract.service.ContractServiceImpl;
import com.tracking.system.company.contract.service.model.Contract;
import com.tracking.system.company.service.CompanyServiceImpl;
import com.tracking.system.company.service.model.Company;
import com.tracking.system.contact.service.model.UserContact;
import com.tracking.system.user.service.UserServiceImpl;
import com.tracking.system.user.service.model.User;
import com.tracking.system.utils.GlobalConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.tracking.system.utils.GlobalConstant.UserType;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class ContractController {

    private String contractTag = "contract";

    @Autowired
    private ContractServiceImpl contractService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CompanyServiceImpl companyService;

    @RequestMapping("/contract/list")
    public String contractList(Model model) {
        model.addAttribute("tag",contractTag);
        model.addAttribute("contracts",contractService.findAll());
//        GlobalConstant.getLoggedInUsername().ifPresent(f -> {
//            model.addAttribute("userName", f);
//            model.addAttribute("tag",contractTag);
//            model.addAttribute("contracts",contractService.findAll());
//        });
        return "client/contracts/list";
    }
    @RequestMapping("/contract/detail/{id}")
    public String contractDetail(Model model,@PathVariable(value="id") String id){
        model.addAttribute("tag",contractTag);
        model.addAttribute("contract",contractService.findById(Long.parseLong(id)));
        return "client/contracts/detail";
    }
    @RequestMapping("/contract/edit/{id}")
    public String contractEdit(Model model,@PathVariable(value="id") String id){
        model.addAttribute("tag",contractTag);
        model.addAttribute("contract",contractService.findById(Long.parseLong(id)));
        model.addAttribute("clients",getAllClients());
        model.addAttribute("companies",getAllCompanies());
        return "client/contracts/edit";
    }

    @RequestMapping("/contract/add")
    public String contractAdd(Model model){
        model.addAttribute("tag",contractTag);
        model.addAttribute("clients",getAllClients());
        model.addAttribute("companies",getAllCompanies());
        return "client/contracts/add";
    }


    @PostMapping("/contract/action/update")
    @ResponseBody
    public Response updateContact(Contract contract) {
        Contract updatedContract = contractService.update(contract);
        if(updatedContract != null){
            return new Response("success","UserContact sent successfully!");
        }
        return new Response("fail","UserContact sent failed!");
    }

    @PostMapping("/contract/action/add")
    @ResponseBody
    public Response addContact(Contract contract) {
        int companyId = GlobalConstant.getCompanyIdForLoggedInUser();
        if(companyId == 0){
            return new Response("fail","UserContact sent failed!");
        }
        contract.setCompanyId(companyId);
        Contract newContract = contractService.save(contract);
        if(newContract != null){
            return new Response("success","UserContact sent successfully!");
        }
        return new Response("fail","UserContact sent failed!");
    }

    private List<User> getAllClients(){
        return userService.findByType(UserType.CLIENT.getValue());
    }

    private List<Company> getAllCompanies(){
        return companyService.findAll();
    }

}
