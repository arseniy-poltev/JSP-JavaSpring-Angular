package com.tracking.system.company.contract.site.service;

import com.tracking.system.company.contract.service.model.Contract;
import com.tracking.system.company.contract.site.service.model.Site;

import java.util.List;

public interface SiteService {
    List<Site> findAll();
    Site findById(long id);
    Site update(Site site);
    Site save(Site site);
    List<Site> findByContractId(int contractId);
}
