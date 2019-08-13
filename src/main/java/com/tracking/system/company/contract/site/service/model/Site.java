package com.tracking.system.company.contract.site.service.model;

import com.tracking.system.company.client.service.model.Client;
import com.tracking.system.company.contract.service.model.Contract;
import com.tracking.system.company.contract.site.shift.service.model.Shift;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="site")
public class Site implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    //site:contract=N:1
//    @ManyToOne
//    @JoinColumn(name = "contract_id")
//    private Contract contract;

    //*********this site is belongs to contract************
    @Column(name = "contract_id")
    private int contractId;

    @Transient
    private String contractName;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lng")
    private double lng;

    @Column(name = "status")
    private String status;

    @Column(name = "business_contact_email")
    private String businessContactEmail;

    @Column(name = "operations_contact_email")
    private String operationsContactEmail;


    @Column(name = "employee_id")
    private int employeeId;


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "shift_id")
//    private Shift shift;
//
//    @ManyToOne
//    @JoinColumn(name = "client_id")
//    private Client client;

    public Site() {
    }

    public String getContractName() {
        return contractName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBusinessContactEmail() {
        return businessContactEmail;
    }

    public void setBusinessContactEmail(String businessContactEmail) {
        this.businessContactEmail = businessContactEmail;
    }

    public String getOperationsContactEmail() {
        return operationsContactEmail;
    }

    public void setOperationsContactEmail(String operationsContactEmail) {
        this.operationsContactEmail = operationsContactEmail;
    }
}
