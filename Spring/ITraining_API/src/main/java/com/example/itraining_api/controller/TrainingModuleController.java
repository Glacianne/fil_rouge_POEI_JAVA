package com.example.itraining_api.controller;

import com.example.itraining_api.entity.LearnerAccount;
import com.example.itraining_api.entity.Training;
import com.example.itraining_api.repository.LearnerAccountRepository;
import com.example.itraining_api.repository.TrainingModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainingModuleController {

    @Autowired
    private TrainingModuleRepository trainingModuleRepository;

    @Autowired
    private LearnerAccountRepository learnerAccountRepository;

    @PostMapping("/createTrainingModule")
    public ResponseEntity<String> createTrainingModule(@RequestBody Training training){
        Training savedTrainingModule = null;
        ResponseEntity<String> response = null;
        try{
            savedTrainingModule = trainingModuleRepository.save(training);
            if(savedTrainingModule.getId() > 0){
                response = ResponseEntity.status(HttpStatus.CREATED).body("Training module has succefully been created");
            }
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception has occured due to " + e.getMessage());
        }
        return response;
    }

    @GetMapping("/trainingModuleCatalog")
    public Iterable<Training> findAllTrainingModule(){
        return trainingModuleRepository.findAll();
    }

    @PostMapping("/addLearner")
    public ResponseEntity<String> addLearner(@RequestParam int trainingId, @RequestParam int learnerId){
        ResponseEntity<String> response = null;
        try {
            Training training = trainingModuleRepository.findById(trainingId).orElse(null);
            LearnerAccount learnerAccount = learnerAccountRepository.findById(learnerId).orElse(null);
            if (training == null) {
                throw new IllegalArgumentException("Training ID not found");
            }
            if (learnerAccount == null) {
                throw new IllegalArgumentException("Learner ID not found");
            }
            learnerAccount.setRegisteredTraining(training);
            learnerAccountRepository.save(learnerAccount);
            response = ResponseEntity.status(HttpStatus.OK).body("Learner added to training");
        }catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception has occured due to " + e.getMessage());
        }
        return response;
    }
}
