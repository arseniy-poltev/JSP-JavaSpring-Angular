package com.tracking.system.company.repository;


import com.tracking.system.company.service.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, String> {
    Company findById(@Param("id") long id);
    Company findByInternalName(@Param("internalName") String internalName);
}
