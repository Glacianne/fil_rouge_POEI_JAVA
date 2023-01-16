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

    public int id_session;
    
    public Date startDate;

    public Date endDate;

    @OneToMany(mappedBy = "trainingSession")
    public List<Session> listSession;

    @OneToMany(mappedBy = "trainingLearner")
    public List<LearnerAccount> LearnerTraining;

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

    public int getId_session() {
        return id_session;
    }

    public void setId_session(int id_session) {
        this.id_session = id_session;
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

    public List<LearnerAccount> getLearnerTraining() {
        return LearnerTraining;
    }

    public void setLearnerTraining(List<LearnerAccount> learnerTraining) {
        LearnerTraining = learnerTraining;
    }

    public Training(int id_session, Date startDate, Date endDate, List<Session> listSession, List<LearnerAccount> learnerTraining) {
        this.id_session = id_session;
        this.startDate = startDate;
        this.endDate = endDate;
        this.listSession = listSession;
        LearnerTraining = learnerTraining;
    }

    public Training() {
    }
}


