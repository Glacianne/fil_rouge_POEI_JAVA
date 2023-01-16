package com.example.itraining_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;
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

    @OneToMany(mappedBy = "teacher")
    public List<Session> TeacherSession;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
