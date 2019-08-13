package com.tracking.system.user.service.model;


import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class DetailUser extends org.springframework.security.core.userdetails.User{
    private static final long serialVersionUID = 1L;

    private String type;
    private String companyName;
    private int companyId;
    public DetailUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
                            String type, String companyName,int companyId) {
        super(username, password, authorities);
        this.type = type;
        this.companyName = companyName;
        this.companyId = companyId;

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}