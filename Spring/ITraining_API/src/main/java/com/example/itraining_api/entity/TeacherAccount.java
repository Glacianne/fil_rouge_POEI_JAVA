package com.example.itraining_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name="TeacherAccount")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class TeacherAccount extends UserAccount {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    public int id;

    public String subject;

    public Double experience;
@JsonIgnore
    @OneToMany(mappedBy = "teacher")
    public List<Session> TeacherSession;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

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

    public List<Session> getTeacherSession() {
        return TeacherSession;
    }

    public void setTeacherSession(List<Session> teacherSession) {
        TeacherSession = teacherSession;
    }

    public TeacherAccount(String firstName, String lastName, String email, String phone, String password, String subject, Double experience, List<Session> teacherSession) {
        super(firstName, lastName, email, phone, password);
        this.subject = subject;
        this.experience = experience;
        TeacherSession = teacherSession;
    }

    public TeacherAccount() {
    }
}
