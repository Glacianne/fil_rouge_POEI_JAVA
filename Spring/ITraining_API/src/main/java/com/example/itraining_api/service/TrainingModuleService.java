package com.example.itraining_api.service;

import com.example.itraining_api.entity.Training;

import java.util.List;

public interface TrainingModuleService {

    Training saveTrainingModule(Training training);

    List<Training> findTrainingModuleList();

    Training findTrainingModuleById(int id);

    Training updateTrainingModule(Training training, int id);

    void deleteTrainingModuleById(int id);
}
