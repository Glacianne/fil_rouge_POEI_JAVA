package com.example.itraining_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TeacherAccount")
@Data
public class TeacherAccount extends UserAccount {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "Teacher_account_id")
    public int id;

}
