package com.example.itraining_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.itraining_api.entity.LearnerAccount;

@Repository
public interface LearnerAccountRepository extends CrudRepository<LearnerAccount, Integer> {

}
