package com.tracking.system.company.contract.repository;

import com.tracking.system.company.contract.service.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, String>{
    List<Contract> findAll();
    Contract findById(@Param("id") long id);
    List<Contract> findByCompanyId(@Param("companyId") int companyId);
}
