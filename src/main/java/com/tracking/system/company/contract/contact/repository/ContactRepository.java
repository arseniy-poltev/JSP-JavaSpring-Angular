package com.tracking.system.company.contract.contact.repository;

import com.tracking.system.company.contract.contact.service.model.ContractContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository<ContractContact, String> {
    List<ContractContact> findByContractId(@Param("contract_id") int id);
}
