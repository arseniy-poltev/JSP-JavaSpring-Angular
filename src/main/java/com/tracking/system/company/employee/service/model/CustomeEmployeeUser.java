package com.tracking.system.company.employee.service.model;
public class CustomeEmployeeUser{
    private String loginName;
    private String firstName;
    private String lastName;
    private String password;
    private String status;
    private String email;
    private String phone;
    private String personalId;
    private String workType;
    private String employeeType;

    public CustomeEmployeeUser() {
    }

    public 

    public CustomeEmployeeUser(String loginName, String firstName, String lastName, String password, String status, String email, String phone, String personalId, String workType, String employeeType) {
        this.loginName = loginName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.status = status;
        this.email = email;
        this.phone = phone;
        this.personalId = personalId;
        this.workType = workType;
        this.employeeType = employeeType;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
}