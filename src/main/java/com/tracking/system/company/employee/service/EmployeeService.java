package com.tracking.system.company.employee.service;

import com.tracking.system.company.employee.service.model.Employee;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeService {
    Employee findById(long id);
    List<Employee> findByAssignedContract(int contractId);
    Employee save(Employee employee);
    List<Employee> findByCompanyId(int companyId);
    String assignEmployeeToSite(int employeeId,int siteId);
    String removeEmployeeFromSite(int employeeId);
    String enableEmployee(int employeeId);
    String disableEmployee(int employeeId);
}
