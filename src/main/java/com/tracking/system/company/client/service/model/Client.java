package com.tracking.system.company.client.service.model;

import com.tracking.system.company.contract.service.model.Contract;
import com.tracking.system.company.contract.site.service.model.Site;
import com.tracking.system.user.service.model.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="client")
public class Client{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private int userId;

    //client:contract = 1:N
//    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Set<Contract> assignedContracts;
//
//    //client:site = 1:N
//    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Set<Site> assignedSites;

    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    //    public Set<Contract> getAssignedContracts() {
//        return assignedContracts;
//    }
//
//    public void setAssignedContracts(Set<Contract> assignedContracts) {
//        this.assignedContracts = assignedContracts;
//    }
//
//    public Set<Site> getAssignedSites() {
//        return assignedSites;
//    }
//
//    public void setAssignedSites(Set<Site> assignedSites) {
//        this.assignedSites = assignedSites;
//    }
}
