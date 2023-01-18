package com.example.itraining_api.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TeacherAccount")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class TeacherAccount extends UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    public int id;

    public String subject;

    public Double experience;

    @OneToMany(mappedBy = "teacher")
    public List<Session> sessionList;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getExperience() {
        return experience;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<Session> sessionList) {
        sessionList = sessionList;
    }

    public TeacherAccount(String firstName, String lastName, String email, String phone, String password, String subject, Double experience, List<Session> sessionList) {
        super(firstName, lastName, email, phone, password);
        this.subject = subject;
        this.experience = experience;
        sessionList = sessionList;
    }

    public TeacherAccount() {
    }
}
