package com.example.itraining_api.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="AdministratorAccount")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AdministratorAccount extends UserAccount{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    public int id;

}
