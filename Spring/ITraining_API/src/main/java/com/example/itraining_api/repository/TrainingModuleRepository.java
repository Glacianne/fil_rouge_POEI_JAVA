package com.example.itraining_api.repository;

import com.example.itraining_api.entity.Training;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TrainingModuleRepository extends CrudRepository<Training, Integer> {

}
