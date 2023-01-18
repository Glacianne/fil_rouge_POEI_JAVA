package com.example.itraining_api.entity;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Session")

public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    public int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sessionTeacher")
    public TeacherAccount teacher;

    public Date startDate;

    public Date endDate;

    public String room;

    public Boolean status;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "trainingmodule_id")
    public TrainingModule affiliatedTrainingModule;


    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }



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

    public TeacherAccount getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherAccount teacher) {
        this.teacher = teacher;
    }

    public TrainingModule getAffiliatedTrainingModule() {
        return affiliatedTrainingModule;
    }

    public void setAffiliatedTrainingModule(TrainingModule trainingSession) {
        this.affiliatedTrainingModule = trainingSession;
    }

    public Session(TeacherAccount teacher, Date startDate, Date endDate, String room, Boolean status,
            TrainingModule trainingSession) {
        this.teacher = teacher;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.status = status;
        this.affiliatedTrainingModule = trainingSession;
    }

    public Session() {
    }
}


