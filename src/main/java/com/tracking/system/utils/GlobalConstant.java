package com.tracking.system.utils;

import com.tracking.system.user.service.model.DetailUser;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public class GlobalConstant {
    public enum UserType{
        ADMIN ("ADMIN"),
        CLIENT ("CLIENT"),
        EMPLOYEE ("EMPLOYEE"),
        SUPERADMIN ("SUPERADMIN");
        private final String value;

        UserType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum Status{
        ACTIVE ("active"),
        SUSPENDED ("suspended"),
        DELETED ("deleted");
        private final String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum WorkType{
        FULLDAY ("fullday"),
        HALFDAY ("halfday");
        private final String value;

        WorkType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum EmployeeType{
        MAINTENANCE ("maintenance"),
        CLEANING ("cleaning");
        private final String value;

        EmployeeType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum ContractStatus{
        ACTIVE ("active"),
        INACTIVE ("inactive");
        private final String value;

        ContractStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum SiteStatus{
        ACTIVE ("active"),
        INACTIVE ("inactive");
        private final String value;

        SiteStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum ShiftStatus{
        SCHEDULED ("scheduled"),
        CANCELLED ("cancelled"),
        ONGOING ("ongoing"),
        FAILED ("failed");
        private final String value;

        ShiftStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }
    public enum Event{
        CREATED ("created"),
        CANCELLED ("cancelled"),
        STARTED ("started"),
        FINISHED ("finished"),
        FAILED ("failed");
        private final String value;

        Event(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public enum AttachmentType{
        Employee_Insurance ("Employee_Insurance"),
        Employee_Picture ("Employee_Picture"),
        Employee_ID ("Employee_ID"),
        Employee_Fiscal_Id ("Employee_Fiscal_Id"),
        Contract_Picture ("Contract_Picture"),
        Company_Picture ("Company_Picture");
        private final String value;

        AttachmentType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static Optional<String> getLoggedInUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = null;
        if (auth != null && !auth.getClass().equals(AnonymousAuthenticationToken.class)) {
            // User user = (User) auth.getPrincipal();
            User userDetails = (User) auth.getPrincipal();
            userName = userDetails.getUsername();
        }

        return Optional.ofNullable(userName);
    }

    public static int getCompanyIdForLoggedInUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int cId = 0;
        if (auth != null && !auth.getClass().equals(AnonymousAuthenticationToken.class)) {
            DetailUser detailUser = (DetailUser)auth.getPrincipal();
            cId = detailUser.getCompanyId();
        }
        return cId;
    }

}
