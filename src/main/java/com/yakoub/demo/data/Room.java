package com.yakoub.demo.data;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID")
    private Long  id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "ROOM_NUMBER" , unique = true, nullable = false , length = 2)
    private String room_number;

    @NotNull
    @Column(name = "BED_INFO" , unique = true, nullable = false , length = 2)
    private String bed_info;

    public Room() {
    }

    public Room(Long id, String name, String room_number, String bed_info) {
        this.id = id;
        this.name = name;
        this.room_number = room_number;
        this.bed_info = bed_info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getBed_info() {
        return bed_info;
    }

    public void setBed_info(String bed_info) {
        this.bed_info = bed_info;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", room_number='" + room_number + '\'' +
                ", bed_info='" + bed_info + '\'' +
                '}';
    }
}
