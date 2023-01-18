package com.example.itraining_api.repository;

import com.example.itraining_api.entity.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends CrudRepository<Session, Integer> {
}
