package com.tracking.system.company.contract.site.service;

import com.tracking.system.company.contract.service.ContractServiceImpl;
import com.tracking.system.company.contract.service.model.Contract;
import com.tracking.system.company.contract.site.repository.SiteRepository;
import com.tracking.system.company.contract.site.service.model.Site;
import com.tracking.system.user.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteServiceImpl implements SiteService{
    private static final Logger LOG = LoggerFactory
            .getLogger(SiteServiceImpl.class);

    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private ContractServiceImpl contractService;
    @Autowired
    private UserServiceImpl userService;

    @Override
    public List<Site> findAll() {
        List<Site> sites = siteRepository.findAll();
        int i;
        for(i=0;i<sites.size();i++){
            Site site = sites.get(i);
            modifyModel(site);
        }
        return sites;
    }
    private void modifyModel(Site site){
        if(site != null)
            site.setContractName(contractService.findById((long)site.getContractId()).getName());
    }

    @Override
    public Site findById(long id) {
        Site site = siteRepository.findById(id);
        modifyModel(site);
        return site;
    }

    @Override
    public Site update(Site site) {
        Site newSite = siteRepository.findById(site.getId());
        newSite.setName(site.getName());
        newSite.setAddress(site.getAddress());
        newSite.setLat(site.getLat());
        newSite.setLng(site.getLng());
        newSite.setOperationsContactEmail(site.getOperationsContactEmail());
        newSite.setBusinessContactEmail(site.getBusinessContactEmail());
        return siteRepository.save(newSite);
    }

    @Override
    public Site save(Site site) {
        return siteRepository.save(site);
    }

    @Override
    public List<Site> findByContractId(int contractId) {
        return siteRepository.findByContractId(contractId);
    }
}
