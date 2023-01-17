package com.example.itraining_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.itraining_api.entity.TeacherAccount;

@Repository
public interface TeacherAccountRepository extends CrudRepository<TeacherAccount, Integer> {

}
