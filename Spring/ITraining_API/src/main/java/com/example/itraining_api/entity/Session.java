package com.example.itraining_api.entity;


import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Session")
@Data
public class Session {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "session_id")
    public int id;

    public String teacher;

    public int nb_session;
    
    public Date startDate;

    public Date endDate;

    public String room;

    public Boolean status;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStart_date(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }




    public Session(String teacher, Date startDate, Date endDate, String room, Boolean status ) {
        this.teacher = teacher;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.status = status;

    }

    public Session() {
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Session{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                ", start_date=" + startDate +
                ", end_date=" + endDate +
                ", room=" + room +
                ", status=" + status +
                '}';
    }


}


