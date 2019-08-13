package com.tracking.system.company.contract.contact.service;

import com.tracking.system.company.contract.contact.repository.ContactRepository;
import com.tracking.system.company.contract.contact.service.model.ContractContact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private static final Logger LOG = LoggerFactory
            .getLogger(ContactServiceImpl.class);

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<ContractContact> findByContractId(long id) {
        return contactRepository.findByContractId((int)id);
    }
}
