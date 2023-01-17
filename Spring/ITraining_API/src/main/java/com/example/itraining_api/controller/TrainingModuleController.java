package com.example.itraining_api.controller;

import com.example.itraining_api.entity.LearnerAccount;
import com.example.itraining_api.entity.Training;
import com.example.itraining_api.repository.LearnerAccountRepository;
import com.example.itraining_api.repository.TrainingModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    @DeleteMapping("/deleteTrainingModule/{id}")
    public ResponseEntity<String> deleteTrainingModule(@PathVariable int id){
        try{
            Training training = trainingModuleRepository.findById(id).orElse(null);
            trainingModuleRepository.delete(training);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception has occured due to " + e.getMessage());
        }

        return ResponseEntity.ok("Formation supprimée");

    }

    @PutMapping("/trainingModule/{id}")
    public ResponseEntity<String> updateTrainingModule(@PathVariable int id, @RequestBody Training trainingDetails){
        try{
            Training training = trainingModuleRepository.findById(id).orElse(null);
           training.setIntitulé(trainingDetails.getIntitulé());
           training.setStartDate(trainingDetails.getStartDate());
           training.setEndDate(trainingDetails.getEndDate());
           training.setListSession(trainingDetails.getListSession());
           training.setRegisteredLearners(trainingDetails.getRegisteredLearners());
           trainingModuleRepository.save(training);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception has occured due to " + e.getMessage());
        }
        return ResponseEntity.ok("Formation mise à jour");
    }

    @GetMapping("/trainingModuleCatalog")
    public ResponseEntity<ArrayList<Training>> findAllTrainingModule(){
        ArrayList<Training> response = new ArrayList<Training>();
        try{
           response = (ArrayList<Training>) trainingModuleRepository.findAll();
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/trainingModule/{id}")
    public ResponseEntity<Training> findTrainingModuleById(@PathVariable int id){
        Training response = null;
        try{
        response = trainingModuleRepository.findById(id).orElse(null);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
        return ResponseEntity.ok(response);
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
