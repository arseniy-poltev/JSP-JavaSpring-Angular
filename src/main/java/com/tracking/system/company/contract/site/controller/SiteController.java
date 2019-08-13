package com.tracking.system.company.contract.site.controller;

import com.tracking.response.Response;
import com.tracking.system.company.contract.service.ContractServiceImpl;
import com.tracking.system.company.contract.service.model.Contract;
import com.tracking.system.company.contract.site.service.SiteService;
import com.tracking.system.company.contract.site.service.SiteServiceImpl;
import com.tracking.system.company.contract.site.service.model.Site;
import com.tracking.system.company.employee.service.EmployeeServiceImpl;
import com.tracking.system.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SiteController {
    private String contractTag = "contract";

    @Autowired
    private SiteServiceImpl siteService;

    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private ContractServiceImpl contractService;

    @RequestMapping("/site/list")
    public String siteList(Model model) {
        model.addAttribute("tag", contractTag);
        model.addAttribute("sites", siteService.findAll());
        return "client/sites/list";
    }

    @RequestMapping("/site/detail/{id}")
    public String siteDetail(Model model, @PathVariable(value = "id") String id) {
        Site site = siteService.findById(Long.parseLong(id));
        model.addAttribute("tag", contractTag);
        model.addAttribute("site", site);
        model.addAttribute("employees", employeeService.findByAssignedContract(site.getContractId()));
        return "client/sites/detail";
    }
    @RequestMapping("/site/edit/{id}")
    public String siteEdit(Model model,@PathVariable(value="id") String id){
        model.addAttribute("tag",contractTag);
        model.addAttribute("site",siteService.findById(Long.parseLong(id)));
        //model.addAttribute("employees",getAllContract(1));
        return "client/sites/edit";
    }
    @RequestMapping("/site/add")
    public String siteAdd(Model model){
        model.addAttribute("tag",contractTag);
        model.addAttribute("contracts",getAllContract(1));
        return "client/sites/add";
    }

    @PostMapping("/site/action/update")
    @ResponseBody
    public Response updateSite(Site site) {
        Site updatedSite = siteService.update(site);
        if(updatedSite != null){
            return new Response("success","UserContact sent successfully!");
        }
        return new Response("fail","UserContact sent failed!");
    }

    @PostMapping("/site/action/add")
    @ResponseBody
    public Response addSite(Site site) {
        Site newSite = siteService.save(site);
        if(newSite != null){
            return new Response("success","UserContact sent successfully!");
        }
        return new Response("fail","UserContact sent failed!");
    }

    @PostMapping("/site/get")
    @ResponseBody
    public List<Site> getSites(int contractId) {
        return siteService.findByContractId(contractId);
    }

    private List<Contract> getAllContract(int companyId){
        return contractService.findByCompanyId(companyId);
    }
}
