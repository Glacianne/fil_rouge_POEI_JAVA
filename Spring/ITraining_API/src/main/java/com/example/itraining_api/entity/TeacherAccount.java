package com.example.itraining_api.entity;

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
    public List<Session> TeacherSession;

    public TeacherAccount(String firstName, String lastName, String email, String phone, String password,
            String subject, Double experience, List<Session> teacherSession) {
        super(firstName, lastName, email, phone, password);
        this.subject = subject;
        this.experience = experience;
        TeacherSession = teacherSession;
    }

    public TeacherAccount() {
    }
}
