package com.tracking.system.company.employee.service.model;

import com.tracking.system.company.employee.trackinposition.service.model.TrackingPosition;
import com.tracking.system.user.service.model.User;
import com.tracking.system.utils.GlobalConstant.*;
import com.tracking.system.company.contract.service.model.Contract;
import com.tracking.system.utils.attachment.service.model.Attachment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "activated_on")
    private Date activatedOn;

    @Column(name = "personal_id")
    private String personalId;

    //employee:attachment = 1:N
    //@OneToMany(mappedBy = "",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Attachment> attachments = new HashSet<>();

    @Column(name = "work_type")
    private String workType;

    //employee:contract = N:1
//    @ManyToOne
//    @JoinColumn(name="contract_id")
//    private Contract assignedContract;
    @Column(name = "assigned_contract")
    private int assignedContract;

    @Transient
    private String assignedContractName;

    @Column(name = "employee_type")
    private String employeeType;

    @Column(name = "site_id")
    private int siteId;

    @Column(name = "user_id")
    private int userId;

    @Transient
    private User userInfo;

    @Column(name = "company_id")
    private int companyId;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "position_id")
//    private TrackingPosition position;

    public Employee() {

    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

//    public Set<Attachment> getAttachments() {
//        return attachments;
//    }
//
//    public void setAttachments(Set<Attachment> attachments) {
//        this.attachments = attachments;
//    }



    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getActivatedOn() {
        return activatedOn;
    }

    public void setActivatedOn(Date activatedOn) {
        this.activatedOn = activatedOn;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public int getAssignedContract() {
        return assignedContract;
    }

    public void setAssignedContract(int assignedContract) {
        this.assignedContract = assignedContract;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }

    public String getAssignedContractName() {
        return assignedContractName;
    }

    public void setAssignedContractName(String assignedContractName) {
        this.assignedContractName = assignedContractName;
    }
}
