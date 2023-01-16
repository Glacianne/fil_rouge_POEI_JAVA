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

    public String entreprise;

    @ManyToOne
    @JoinColumn(name="TRAINING_ID")
    public Training trainingLearner;





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
