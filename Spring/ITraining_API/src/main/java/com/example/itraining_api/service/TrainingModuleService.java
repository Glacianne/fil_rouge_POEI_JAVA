package com.example.itraining_api.service;

import com.example.itraining_api.entity.TrainingModule;

import java.util.List;

public interface TrainingModuleService {

    TrainingModule saveTrainingModule(TrainingModule training);

    List<TrainingModule> findTrainingModuleList();

    TrainingModule findTrainingModuleById(int id);

    TrainingModule updateTrainingModule(TrainingModule training, int id);

    void deleteTrainingModuleById(int id);
}
