package com.example.itraining_api.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TrainingModule")
public class TrainingModule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    public int id;
    public String title;

    public Date startDate;

    public Date endDate;

    @OneToMany(mappedBy = "affiliatedTrainingModule")
    public List<Session> sessionList;

    @ManyToMany(mappedBy = "registeredTrainingList")
    public List<LearnerAccount> registeredLearnerList;

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

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<Session> listSession) {
        this.sessionList = listSession;
    }

    public List<LearnerAccount> getRegisteredLearnerList() {
        return registeredLearnerList;
    }

    public void setRegisteredLearnerList(List<LearnerAccount> registeredLearnerList) {
        this.registeredLearnerList = registeredLearnerList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String intitulé) {
        this.title = intitulé;
    }

    public TrainingModule(String intitulé, Date startDate, Date endDate, List<Session> listSession,
            List<LearnerAccount> registeredLearnerList) {
        this.title = intitulé;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sessionList = listSession;
        this.registeredLearnerList = registeredLearnerList;
    }

    public TrainingModule() {
    }
}
