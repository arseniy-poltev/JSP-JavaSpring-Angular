package com.tracking.system.company.service;

import com.tracking.system.company.service.model.Company;

import java.util.List;

public interface CompanyService{
    List<Company> findAll();
    Company findById(long id);
    Company findByInternalName(String internalName);
    Company save(Company company);
}
