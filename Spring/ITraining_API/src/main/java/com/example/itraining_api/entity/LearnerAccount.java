package com.example.itraining_api.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name="LearnerAccount")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class LearnerAccount extends UserAccount{


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    public int id;


    @ManyToOne
    @JoinColumn(name="TRAINING_ID")
    public Training trainingLearner;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Training getTrainingLearner() {
        return trainingLearner;
    }

    public void setTrainingLearner(Training trainingLearner) {
        this.trainingLearner = trainingLearner;
    }

    public LearnerAccount(String firstName, String lastName, String email, String phone, String password, Training trainingLearner) {
        super(firstName, lastName, email, phone, password);
        this.trainingLearner = trainingLearner;
    }

    public LearnerAccount() {
    }
}
