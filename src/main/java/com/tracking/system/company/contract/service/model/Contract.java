package com.tracking.system.company.contract.service.model;

import com.tracking.system.company.client.service.model.Client;
import com.tracking.system.company.contract.contact.service.model.ContractContact;
import com.tracking.system.company.contract.site.service.model.Site;
import com.tracking.system.company.employee.service.model.Employee;
import com.tracking.system.company.service.CompanyServiceImpl;
import com.tracking.system.company.service.model.Company;
import com.tracking.system.user.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="contract")
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    //contract:company=N:1
//    @ManyToOne
//    @JoinColumn(name = "company_id")
//    private Company company;
    @Column(name = "company_id")
    private int companyId;


    @Column(name = "status",nullable = false, columnDefinition = "varchar(50) default 'active'")
    private String status;

    @Column(name = "name")
    private String name;

    @Column(name = "customer_name")
    private String customerName;


    @Column(name = "operations_manager")
    private int operationsManager;
//    private User operationsManager;

    @Transient
    private String companyName;
    @Transient
    private String operationManagerName;
    @Transient
    private List<ContractContact> contacts;


    //contract:site = 1:N
//    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Set<Site> sites = new HashSet<>();
//
//    //contract:contact=1:N
//    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Set<ContractContact> contacts = new HashSet<>();


//    @ManyToOne
//    @JoinColumn(name = "client_id")
//    private Client client;
//
//    @OneToMany(mappedBy = "assignedContract",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Set<Employee> employees = new HashSet<>();

    public Contract() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getOperationsManager() {
        return operationsManager;
    }

    public void setOperationsManager(int operationsManager) {
        this.operationsManager = operationsManager;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOperationManagerName() {
        return operationManagerName;
    }

    public void setOperationManagerName(String operationManagerName) {
        this.operationManagerName = operationManagerName;
    }

    public List<ContractContact> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContractContact> contacts) {
        this.contacts = contacts;
    }
}
