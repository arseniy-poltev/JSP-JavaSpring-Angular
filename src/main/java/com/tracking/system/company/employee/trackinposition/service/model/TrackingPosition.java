package com.tracking.system.company.employee.trackinposition.service.model;


import com.tracking.system.company.employee.service.model.Employee;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="tracking_position")
public class TrackingPosition implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lng")
    private double lng;

    @Column(name = "last_lat_lng_date")
    private Date lastLatLngDate;

//    @OneToOne(mappedBy = "position")
//    private Employee employee;
    @Column(name = "employee_id")
    private int employeeId;

    public TrackingPosition() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
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

    public Date getLastLatLngDate() {
        return lastLatLngDate;
    }

    public void setLastLatLngDate(Date lastLatLngDate) {
        this.lastLatLngDate = lastLatLngDate;
    }

}
