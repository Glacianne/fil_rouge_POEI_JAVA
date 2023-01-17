package com.example.itraining_api.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.itraining_api.entity.LearnerAccount;

public interface LearnerAccountRepository extends CrudRepository<LearnerAccount, Integer> {

}
