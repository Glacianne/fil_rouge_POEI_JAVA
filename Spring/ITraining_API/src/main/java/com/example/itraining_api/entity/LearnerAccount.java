package com.example.itraining_api.entity;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
    @ManyToMany
    @JoinColumn(name = "TRAINING_ID")
    public List<TrainingModule> registeredTrainingList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LearnerAccount(String firstName, String lastName, String email, String phone, String password,
            List<TrainingModule> registeredTrainingList) {
        super(firstName, lastName, email, phone, password);
        this.registeredTrainingList = registeredTrainingList;
    }

    public LearnerAccount() {
    }

    public List<TrainingModule> getRegisteredTrainingList() {
        return registeredTrainingList;
    }

    public void setRegisteredTrainingList(List<TrainingModule> registeredTrainingList) {
        this.registeredTrainingList = registeredTrainingList;
    }
}
