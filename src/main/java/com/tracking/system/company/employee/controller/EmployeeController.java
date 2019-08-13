package com.tracking.system.company.employee.controller;

import com.tracking.response.Response;
import com.tracking.system.company.employee.service.model.CustomeEmployeeUser;
import com.tracking.system.utils.GlobalConstant.Status;
import com.tracking.system.utils.GlobalConstant.WorkType;
import com.tracking.system.utils.GlobalConstant.EmployeeType;
import com.tracking.system.company.contract.service.ContractServiceImpl;
import com.tracking.system.company.contract.service.model.Contract;
import com.tracking.system.company.contract.site.service.SiteService;
import com.tracking.system.company.contract.site.service.SiteServiceImpl;
import com.tracking.system.company.contract.site.service.model.Site;
import com.tracking.system.company.employee.service.EmployeeServiceImpl;
import com.tracking.system.company.employee.service.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    private String contractTag = "contract";



    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    ContractServiceImpl contractService;
    @Autowired
    SiteServiceImpl siteService;

    private List<String> statusList = new ArrayList<>();
    private List<String> workTypeList = new ArrayList<>();
    private List<String> employeeTypeList = new ArrayList<>();

    EmployeeController(){
        for(Status status : Status.values()){
            statusList.add(status.getValue());
        }
        for(WorkType workType : WorkType.values()){
            workTypeList.add(workType.getValue());
        }
        for(EmployeeType employeeType : EmployeeType.values()){
            employeeTypeList.add(employeeType.getValue());
        }
    }
    @RequestMapping("/employee/list")
    public String employeeList(Model model) {
        model.addAttribute("tag",contractTag);
        model.addAttribute("employees",employeeService.findByCompanyId(1));
        model.addAttribute("contracts",getAllContract(1));
        return "client/employee/list";
    }

    @RequestMapping("/employee/detail/{id}")
    public String employeeDetail(Model model,@PathVariable(value="id") String id){
        model.addAttribute("tag",contractTag);
        model.addAttribute("employee",employeeService.findById(Long.parseLong(id)));
        model.addAttribute("contracts",getAllContract(1));
        return "client/employee/detail";
    }
    @RequestMapping("/employee/edit/{id}")
    public String employeeEdit(Model model,@PathVariable(value="id") String id){
        model.addAttribute("tag",contractTag);
        model.addAttribute("employee",employeeService.findById(Long.parseLong(id)));
        model.addAttribute("statusList",statusList);
        model.addAttribute("workTypeList",workTypeList);
        model.addAttribute("employeeTypeList",employeeTypeList);
        //model.addAttribute("contracts",getAllContract(1));
        return "client/employee/edit";
    }
    @RequestMapping("/employee/add")
    public String employeeAdd(Model model){
        model.addAttribute("tag",contractTag);
        model.addAttribute("statusList",statusList);
        model.addAttribute("workTypeList",workTypeList);
        model.addAttribute("employeeTypeList",employeeTypeList);
        return "client/employee/add";
    }


    @PostMapping("/employee/action/assign")
    @ResponseBody
    public Response assignEmployee(int employeeId,int siteId) {
        String message = employeeService.assignEmployeeToSite(employeeId,siteId);
        if(!message.equals("success")){
            return new Response("fail",message);
        }
        Site site = siteService.findById((long)siteId);
        return new Response("success",site.getContractName());
    }


    @PostMapping("/employee/action/add")
    @ResponseBody
    public Response addEmployee(CustomeEmployeeUser employeeUser){

    }

    @PostMapping("/employee/action/remove")
    @ResponseBody
    public Response removeFromSite(int employeeId){
        Response response = new Response();
        String message = employeeService.removeEmployeeFromSite(employeeId);
        return getResponse(response, message);
    }
    @PostMapping("/employee/action/enable")
    @ResponseBody
    public Response enableEmployee(int employeeId){
        Response response = new Response();
        String message = employeeService.enableEmployee(employeeId);
        return getResponse(response, message);
    }

    @PostMapping("/employee/action/disable")
    @ResponseBody
    public Response disableEmployee(int employeeId){
        Response response = new Response();
        String message = employeeService.disableEmployee(employeeId);
        return getResponse(response, message);
    }


    private Response getResponse(Response response, String message) {
        if(!message.equals("success")){
            response.setStatus("fail");
            response.setMessage(message);
            return response;
        }
        response.setStatus("success");
        return response;
    }


    private List<Contract> getAllContract(int companyId){
        return contractService.findByCompanyId(companyId);
    }
}
