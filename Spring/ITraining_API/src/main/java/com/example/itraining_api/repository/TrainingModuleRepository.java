package com.example.itraining_api.repository;

import com.example.itraining_api.entity.Training;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrainingModuleRepository extends CrudRepository<Training, Integer> {

}
