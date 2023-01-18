package com.example.itraining_api.dto;

import com.example.itraining_api.entity.TeacherAccount;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class SessionDTO {


    public Integer teacherId;

    public Date startDate;

    public Date endDate;

    public String room;

    public Boolean status;

    public Integer trainingSessionId;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getTrainingSessionId() {
        return trainingSessionId;
    }

    public void setTrainingSessionId(Integer trainingSessionId) {
        this.trainingSessionId = trainingSessionId;
    }

    public SessionDTO() {
    }



    public SessionDTO(Integer teacherId, Date startDate, Date endDate, String room, Boolean status, Integer trainingSessionId) {
        this.teacherId = teacherId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.status = status;
        this.trainingSessionId = trainingSessionId;
    }
}
