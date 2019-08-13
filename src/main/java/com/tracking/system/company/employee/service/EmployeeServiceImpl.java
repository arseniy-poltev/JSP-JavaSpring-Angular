package com.tracking.system.company.employee.service;

import com.tracking.system.company.contract.service.ContractServiceImpl;
import com.tracking.system.company.contract.service.model.Contract;
import com.tracking.system.company.contract.site.service.SiteServiceImpl;
import com.tracking.system.company.contract.site.service.model.Site;
import com.tracking.system.company.employee.repository.EmployeeRepository;
import com.tracking.system.company.employee.service.model.Employee;
import com.tracking.system.user.service.UserServiceImpl;
import com.tracking.system.user.service.model.User;
import com.tracking.system.utils.GlobalConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOG = LoggerFactory
            .getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ContractServiceImpl contractService;
    @Autowired
    private SiteServiceImpl siteService;

    @Override
    public Employee findById(long id) {
        Employee employee = employeeRepository.findById(id);
        modifyModel(employee);
        return employee;
    }

    @Override
    public List<Employee> findByAssignedContract(int contractId) {
        List<Employee> employees = employeeRepository.findByAssignedContract(contractId);
        modifyList(employees);
        return employees;
    }

    @Override
    public List<Employee> findByCompanyId(int companyId) {
        List<Employee> employees = employeeRepository.findByCompanyId(companyId);
        modifyList(employees);
        return employees;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }



    @Override
    public String assignEmployeeToSite(int employeeId, int siteId) {
        Employee employee = employeeRepository.findById((long)employeeId);
        if(employee == null){
            return "There is no employee!";
        }

        if(employee.getSiteId() != 0){
            return "He is already assigned!";
        }

        Site site =  siteService.findById((long)siteId);
        if(site == null){
            return "There is no site";
        }

        if(site.getEmployeeId() != 0){
            return "Someone is already assigned to this site!";
        }
        employee.setSiteId(siteId);
        employee.setAssignedContract(site.getContractId());
        site.setEmployeeId(employeeId);
        siteService.save(site);
        save(employee);
        return "success";
    }

    @Override
    public String removeEmployeeFromSite(int employeeId) {
        Employee employee = employeeRepository.findById((long)employeeId);
        if(employee == null){
            return "There is such employee!";
        }

        Site site = siteService.findById((long)employee.getSiteId());
        if(site != null){
            site.setEmployeeId(0);
            siteService.save(site);
        }
        employee.setSiteId(0);
        employee.setAssignedContract(0);
        save(employee);
        return "success";
    }

    @Override
    public String enableEmployee(int employeeId) {
        return changeStatus(employeeId,GlobalConstant.Status.ACTIVE.getValue());
    }

    @Override
    public String disableEmployee(int employeeId) {
        return changeStatus(employeeId,GlobalConstant.Status.SUSPENDED.getValue());
    }

    private String changeStatus(int employeeId,String status){
        Employee employee = employeeRepository.findById((long)employeeId);
        User user = userService.findById((long)employee.getUserId());
        user.setStatus(status);
        return "success";
    }

    private void modifyList(List<Employee> employees) {
        int i;
        for (i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            modifyModel(employee);
        }
    }

    private void modifyModel(Employee employee) {
        if(employee == null)
            return;
        employee.setUserInfo(userService.findById((long) employee.getUserId()));
        if(employee.getAssignedContract() == 0)
            return;
        Contract contract = contractService.findById((long) employee.getAssignedContract());
        if(contract != null)
            employee.setAssignedContractName(contract.getName());
    }
}
