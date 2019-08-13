package com.tracking.system.company.service.model;

import com.tracking.system.company.contract.service.model.Contract;
import com.tracking.system.user.service.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="company")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "internal_name")
    private String internalName;

    @Column(name = "fantasy_name")
    private String fantasyName;

    @Column(name = "legal_name")
    private String legalName;

    @Column(name = "billing_id")
    private String billingId;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "country")
    private String country;

    @Column(name = "billing_email")
    private String billingEmail;

    @Column(name = "operation_email")
    private String operationsEmail;

    @Column(name = "main_contact_email")
    private String mainContactEmail;

//    @OneToMany(mappedBy = "company")
//    private Set<User> users = new HashSet<>();
//
//    @OneToMany(mappedBy = "company")
//    private Set<Contract> contracts = new HashSet<>();

    public Company() {
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getBillingId() {
        return billingId;
    }

    public void setBillingId(String billingId) {
        this.billingId = billingId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    public String getOperationsEmail() {
        return operationsEmail;
    }

    public void setOperationsEmail(String operationsEmail) {
        this.operationsEmail = operationsEmail;
    }

    public String getMainContactEmail() {
        return mainContactEmail;
    }

    public void setMainContactEmail(String mainContactEmail) {
        this.mainContactEmail = mainContactEmail;
    }
}
