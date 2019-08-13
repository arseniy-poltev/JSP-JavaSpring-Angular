package com.tracking.system.company.employee.repository;

import com.tracking.system.company.employee.service.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String>{
    List<Employee> findAll();
    List<Employee> findByAssignedContract(@Param("assignedContract") int id);
    List<Employee> findByCompanyId(@Param("companyId") int companyId);
    Employee findById(@Param("id") long id);

}
