package com.tracking.system.company.contract.contact.service.model;

import com.tracking.system.company.contract.service.model.Contract;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="contract_contact")
public class ContractContact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    //UserContact:Contract = N:1
//    @ManyToOne
//    @JoinColumn(name = "contract_id")
//    private Contract contract;

    //**********this contact belongs to contact**********
    @Column(name = "contract_id")
    private int contractId;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "name")
    private String name;

    public ContractContact() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
