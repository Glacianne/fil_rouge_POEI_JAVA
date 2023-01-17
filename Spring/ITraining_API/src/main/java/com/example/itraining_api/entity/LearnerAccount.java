package com.example.itraining_api.entity;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LearnerAccount")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class LearnerAccount extends UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    public int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "TRAINING_ID")
    public Training registeredTraining;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Training getRegisteredTraining() {
        return registeredTraining;
    }

    public void setRegisteredTraining(Training registeredTraining) {
        this.registeredTraining = registeredTraining;
    }

    public LearnerAccount(String firstName, String lastName, String email, String phone, String password,
            Training trainingLearner) {
        super(firstName, lastName, email, phone, password);
        this.registeredTraining = trainingLearner;
    }

    public LearnerAccount() {
    }
}
