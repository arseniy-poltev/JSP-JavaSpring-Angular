package com.tracking.system.company.contract.site.repository;

import com.tracking.system.company.contract.service.model.Contract;
import com.tracking.system.company.contract.site.service.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site, String>{

    Site findById(@Param("id") long id);
    List<Site> findByContractId(@Param("contractId") int contractId);
}
