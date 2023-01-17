package com.example.itraining_api.repository;

import com.example.itraining_api.entity.AdministratorAccount;
import com.example.itraining_api.entity.TeacherAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorAccountRepository extends CrudRepository<AdministratorAccount, Integer> {



}
