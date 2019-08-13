package com.tracking.system.company.contract.site.shift.shiftevent.service.model;

import com.tracking.system.company.contract.site.shift.service.model.Shift;
import com.tracking.system.user.service.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="shift_event")
public class ShiftEvent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    //event:shift=N:1
//    @ManyToOne
//    @JoinColumn(name="shift_id")
//    private Shift shift;

    @Column(name = "shift_id")
    private int shiftId;

    @Column(name = "when_time")
    private Date whenTime;

    @Column(name = "event")
    private String event;

    //event:user=N:1
//    private User user;
    @Column(name = "user_id")
    private int userId;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lng")
    private double lng;

    @Column(name = "latlng_date")
    private Date latlngDate;

    public ShiftEvent() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public Date getWhenTime() {
        return whenTime;
    }

    public void setWhenTime(Date whenTime) {
        this.whenTime = whenTime;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Date getLatlngDate() {
        return latlngDate;
    }

    public void setLatlngDate(Date latlngDate) {
        this.latlngDate = latlngDate;
    }
}
