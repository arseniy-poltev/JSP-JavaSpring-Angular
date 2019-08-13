package com.tracking.system.company.contract.site.shift.service.model;

import com.tracking.system.company.contract.site.service.model.Site;
import com.tracking.system.company.contract.site.shift.shiftevent.service.model.ShiftEvent;
import com.tracking.system.company.employee.service.model.Employee;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="shift")
public class Shift implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "when_date")
    private Date whenDate;

    @Column(name = "start_time")
    private Time startTime;

    //shift:site=1:1
//    @OneToOne(mappedBy = "shift")
//    private Site site;

    @Column(name = "site_id")
    private int siteId;

    @Column(name ="employee_id")
    private int employeeId;

    @Column(name = "status")
    private String status;

    //shift:shiftevent = 1:N
//    @OneToMany(mappedBy = "shift",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Set<ShiftEvent> events = new HashSet<>();

    public Shift() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getWhenDate() {
        return whenDate;
    }

    public void setWhenDate(Date whenDate) {
        this.whenDate = whenDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }
}
