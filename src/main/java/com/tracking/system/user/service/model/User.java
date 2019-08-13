package com.tracking.system.user.service.model;
import com.tracking.system.company.service.model.Company;
import com.tracking.system.user.role.service.model.Role;
import com.tracking.system.utils.GlobalConstant.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="user")
public class User implements Serializable {
    //Unique ID of the user (long)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    //First name of the user
    @Column(name = "first_name")
    private String firstName;

    //Last name of the user
    @Column(name = "last_name")
    private String lastName;

    //The login name to be used
    @Column(name = "login_name")
    private String loginName;

    //One-way encrypted
    @Column(name = "password")
    private String password;

    //The Type of user
    /*
    Admin,Client,Employee
    * */
    @Column(name = "type")
    private String type;

    /*One of:
        Active,Suspended,Deleted
    * */
    @Column(name = "Status")
    private String status;

    //An optional email
    @Column(name = "email")
    private String email;

    //An optional cell phone
    @Column(name = "phone")
    private String phone;

    @Column(name = "company_id")
    private int companyId;

    @Transient
    private String companyName;

//    @ManyToOne
//    @JoinColumn(name = "company")
//    private Company company;



    //A List of Role s with their permissions

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
//    private Set<Role> roles = new HashSet();
    @ManyToMany
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(
                name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
                name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}