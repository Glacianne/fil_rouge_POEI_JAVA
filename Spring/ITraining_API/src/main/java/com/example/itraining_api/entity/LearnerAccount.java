package com.example.itraining_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="LearnerAccount")
@Data
public class LearnerAccount extends UserAccount{


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "Learner_account_id")
    public int id;


    
}
