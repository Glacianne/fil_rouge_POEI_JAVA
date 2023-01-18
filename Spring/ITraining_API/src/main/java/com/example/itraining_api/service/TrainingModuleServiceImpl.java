package com.example.itraining_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.itraining_api.entity.TrainingModule;
import com.example.itraining_api.repository.TrainingModuleRepository;

@Service
public class TrainingModuleServiceImpl implements TrainingModuleService {

    @Autowired
    private TrainingModuleRepository trainingModuleRepository;

    @Override
    public TrainingModule saveTrainingModule(TrainingModule training) {
        return trainingModuleRepository.save(training);
    }

    @Override
    public List<TrainingModule> findTrainingModuleList() {
        return (List<TrainingModule>) trainingModuleRepository.findAll();
    }

    @Override
    public TrainingModule findTrainingModuleById(int id) {
        return trainingModuleRepository.findById(id).orElse(null);
    }

    @Override
    public TrainingModule updateTrainingModule(TrainingModule training, int id) {
        TrainingModule training1 = trainingModuleRepository.findById(id).orElse(null);
        return trainingModuleRepository.save(training1);
    }

    @Override
    public void deleteTrainingModuleById(int id) {
        trainingModuleRepository.deleteById(id);
    }
}
