package com.example.itraining_api.entity;


import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="Training")
@Data
public class Training {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "training_theme_id")
    public int id;

    public String teacher;

    public int id_session;
    
    public Date startDate;

    public Date endDate;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Date getStart_date() {
        return startDate;
    }

    public void setStart_date(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEnd_Date() {
        return endDate;
    }

    public void setEnd_Date(Date endDate) {
        this.endDate = endDate;
    }



    public Training(String teacher, Date startDate, Date endDate) {
        this.teacher = teacher;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Training() {
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Training{" +
                "id=" + id +
                ", teacher=" + teacher +
                ", start_date=" + startDate +
                ", end_date=" + endDate +

                '}';
    }
}


