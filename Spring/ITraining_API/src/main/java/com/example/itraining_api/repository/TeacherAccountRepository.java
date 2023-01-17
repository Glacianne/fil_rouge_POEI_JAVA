package com.example.itraining_api.repository;

import com.example.itraining_api.entity.LearnerAccount;
import com.example.itraining_api.entity.TeacherAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherAccountRepository extends CrudRepository<TeacherAccount, Integer> {





}
