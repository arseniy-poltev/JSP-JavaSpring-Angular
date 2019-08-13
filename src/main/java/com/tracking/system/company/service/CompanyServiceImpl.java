package com.tracking.system.company.service;

import com.tracking.system.company.repository.CompanyRepository;
import com.tracking.system.company.service.model.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private static final Logger LOG = LoggerFactory
            .getLogger(CompanyServiceImpl.class);

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }


    @Override
    public Company findById(long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company findByInternalName(String internalName) {
        return companyRepository.findByInternalName(internalName);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }
}
