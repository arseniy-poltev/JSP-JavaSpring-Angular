package com.tracking.system.company.contract.contact.service;

import com.tracking.system.company.contract.contact.service.model.ContractContact;

import java.util.List;

public interface ContactService {
    List<ContractContact> findByContractId(long id);
}
