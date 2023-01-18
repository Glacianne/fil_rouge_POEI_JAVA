package com.example.itraining_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.itraining_api.entity.AdministratorAccount;

@Repository
public interface AdministratorAccountRepository extends CrudRepository<AdministratorAccount, Integer> {

}
