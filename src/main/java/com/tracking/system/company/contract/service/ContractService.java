package com.tracking.system.company.contract.service;

import com.tracking.system.company.contract.service.model.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();
    Contract findById(long id);
    Contract update(Contract contract);
    Contract save(Contract contract);
    List<Contract> findByCompanyId(int companyId);
}
