package com.example.itraining_api.entity;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
@JsonIgnore
    @OneToMany(mappedBy = "trainingSession")
    public List<Session> listSession;
@JsonIgnore
    @OneToMany(mappedBy = "registeredTraining")
    public List<LearnerAccount> registeredLearners;

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

    public List<LearnerAccount> getRegisteredLearners() {
        return registeredLearners;
    }

    public void setRegisteredLearners(List<LearnerAccount> registeredLearners) {
        registeredLearners = registeredLearners;
    }

    public String getIntitulé() {
        return intitulé;
    }

    public void setIntitulé(String intitulé) {
        this.intitulé = intitulé;
    }

    public Training(String intitulé, Date startDate, Date endDate, List<Session> listSession, List<LearnerAccount> registeredLearners) {
        this.intitulé = intitulé;
        this.startDate = startDate;
        this.endDate = endDate;
        this.listSession = listSession;
        registeredLearners = registeredLearners;
    }

    public Training() {
    }
}


