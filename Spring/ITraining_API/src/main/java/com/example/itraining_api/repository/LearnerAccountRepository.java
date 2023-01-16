package com.example.itraining_api.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.itraining_api.entity.LearnerAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnerAccountRepository extends CrudRepository<LearnerAccount, Long> {

}
