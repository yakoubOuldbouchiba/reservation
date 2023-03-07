package com.yakoub.demo.data;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private Long id;

    @Column(name = "ROOM_ID")
    private Long room_id;

    @Column(name = "GUEST_ID")
    private  Long guest_id;

    @Column(name = "RES_DATE")
    private Date resDate;

    public Reservation() {
    }

    public Reservation(Long id, Long room_id, Long guest_id, Date date) {
        this.id = id;
        this.room_id = room_id;
        this.guest_id = guest_id;
        this.resDate = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public Long getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(Long guest_id) {
        this.guest_id = guest_id;
    }

    public Date getDate() {
        return resDate;
    }

    public void setDate(Date date) {
        this.resDate = date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", room_id=" + room_id +
                ", guest_id=" + guest_id +
                ", date=" + resDate +
                '}';
    }
}
