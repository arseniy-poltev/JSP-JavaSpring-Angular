package com.tracking.system.company.contract.service;

import com.tracking.system.company.contract.contact.service.ContactServiceImpl;
import com.tracking.system.company.contract.repository.ContractRepository;
import com.tracking.system.company.contract.service.model.Contract;
import com.tracking.system.company.service.CompanyServiceImpl;
import com.tracking.system.user.service.UserServiceImpl;
import com.tracking.system.utils.GlobalConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    private static final Logger LOG = LoggerFactory
            .getLogger(ContractServiceImpl.class);

    @Autowired
    private ContractRepository contractRepository;


    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ContactServiceImpl contactService;

    @Override
    public List<Contract> findAll() {
        List<Contract> contracts = contractRepository.findAll();
        int i;
        for(i=0;i<contracts.size();i++){
            Contract contract = contracts.get(i);
            modifyModel(contract);
        }
        return contracts;
    }

    @Override
    public Contract findById(long id) {
        Contract contract = contractRepository.findById(id);
        modifyModel(contract);
        return contract;
    }

    private void modifyModel(Contract contract){
        if(contract == null)
            return;
        contract.setCompanyName(companyService.findById((long)contract.getCompanyId()).getLegalName());
        contract.setOperationManagerName(userService.findById((long)contract.getOperationsManager()).getLoginName());
        contract.setContacts(contactService.findByContractId(contract.getId()));
    }

    @Override
    public Contract update(Contract contract) {
        Contract newContract = contractRepository.findById(contract.getId());
        newContract.setName(contract.getName());
        newContract.setCustomerName(contract.getCustomerName());
        return contractRepository.save(newContract);
    }

    @Override
    public Contract save(Contract contract) {
        if(contract.getStatus() == null)
            contract.setStatus(GlobalConstant.ContractStatus.ACTIVE.getValue());
        return contractRepository.save(contract);
    }

    @Override
    public List<Contract> findByCompanyId(int companyId) {
        return contractRepository.findByCompanyId(companyId);
    }
}
