package com.example.itraining_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.itraining_api.entity.Training;
import com.example.itraining_api.repository.TrainingModuleRepository;

@Service
public class TrainingModuleServiceImpl implements TrainingModuleService {

    @Autowired
    private TrainingModuleRepository trainingModuleRepository;

    @Override
    public Training saveTrainingModule(Training training) {
        return trainingModuleRepository.save(training);
    }

    @Override
    public List<Training> findTrainingModuleList() {
        return (List<Training>) trainingModuleRepository.findAll();
    }

    @Override
    public Training findTrainingModuleById(int id) {
        return trainingModuleRepository.findById(id).orElse(null);
    }

    @Override
    public Training updateTrainingModule(Training training, int id) {
        Training training1 = trainingModuleRepository.findById(id).orElse(null);
        return trainingModuleRepository.save(training1);
    }

    @Override
    public void deleteTrainingModuleById(int id) {
        trainingModuleRepository.deleteById(id);
    }
}
