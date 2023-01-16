package com.example.itraining_api.entity;


import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="Training")

public class Training {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    public int id;
    public String intitulé;

    public Date startDate;

    public Date endDate;

    @OneToMany(mappedBy = "trainingSession")
    public List<Session> listSession;

    @OneToMany(mappedBy = "registeredTraining")
    public List<LearnerAccount> registeredTraining;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Session> getListSession() {
        return listSession;
    }

    public void setListSession(List<Session> listSession) {
        this.listSession = listSession;
    }

    public List<LearnerAccount> getRegisteredTraining() {
        return registeredTraining;
    }

    public void setRegisteredTraining(List<LearnerAccount> registeredTraining) {
        registeredTraining = registeredTraining;
    }

    public String getIntitulé() {
        return intitulé;
    }

    public void setIntitulé(String intitulé) {
        this.intitulé = intitulé;
    }

    public Training(String intitulé, Date startDate, Date endDate, List<Session> listSession, List<LearnerAccount> registeredTraining) {
        this.intitulé = intitulé;
        this.startDate = startDate;
        this.endDate = endDate;
        this.listSession = listSession;
        registeredTraining = registeredTraining;
    }

    public Training() {
    }
}


