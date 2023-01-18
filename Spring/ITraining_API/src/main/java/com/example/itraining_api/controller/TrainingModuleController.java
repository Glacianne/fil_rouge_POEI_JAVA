package com.example.itraining_api.controller;

import com.example.itraining_api.entity.LearnerAccount;
import com.example.itraining_api.repository.LearnerAccountRepository;
import com.example.itraining_api.service.LearnerAccountService;
import com.example.itraining_api.service.TrainingModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.itraining_api.entity.TrainingModule;
import com.example.itraining_api.service.TrainingModuleService;

@RestController
@RequestMapping("/trainingModuleController")
public class TrainingModuleController {

    @Autowired
    private TrainingModuleService trainingModuleService;

    @Autowired
    private LearnerAccountService learnerAccountService;


    @PostMapping("/trainingModule")
    public ResponseEntity<Map<String, TrainingModule>> createTrainingModule(@RequestBody TrainingModule trainingModule) {
        Map<String, TrainingModule> hashMap = new HashMap<String, TrainingModule>();
        try {
            hashMap.put("Formation créée", trainingModuleService.saveTrainingModule(trainingModule));
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }

    @DeleteMapping("/trainingModule/{id}")
    public ResponseEntity<String> deleteTrainingModule(@PathVariable int id) {
        try {
            trainingModuleService.deleteTrainingModuleById(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception has occured due to " + e.getMessage());
        }
        return ResponseEntity.ok("Formation supprimée");

    }

    @PutMapping("/trainingModule/{id}")
    public ResponseEntity<Map<String, TrainingModule>> updateTrainingModule(@PathVariable("id") int id,
            @RequestBody TrainingModule trainingDetails) {
        Map<String, TrainingModule> hashMap = new HashMap<String, TrainingModule>();
        try {
            hashMap.put("Formation modifiée", trainingModuleService.updateTrainingModule(trainingDetails, id));
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }

    @GetMapping("/trainingModule")
    public ResponseEntity<Map<String, List<TrainingModule>>> findAllTrainingModule() {
        Map<String, List<TrainingModule>> hashMap = new HashMap<String, List<TrainingModule>>();
        try {
            hashMap.put("Catalogue chargé", trainingModuleService.findTrainingModuleList());
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }

    @GetMapping("/trainingModule/{id}")
    public ResponseEntity<Map<String, TrainingModule>> findTrainingModuleById(@PathVariable int id) {
        Map<String, TrainingModule> hashMap = new HashMap<String, TrainingModule>();
        try {
            hashMap.put("Formation trouvée", trainingModuleService.findTrainingModuleById(id));
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }
        @PostMapping("/addLearnerForTraining")
        public ResponseEntity<Map<String, LearnerAccount>> addLearner(@RequestParam int trainingId, @RequestParam int learnerId){
            Map<String, LearnerAccount> hashMap = new HashMap<String, LearnerAccount>();
            try {
                TrainingModule training = trainingModuleService.findTrainingModuleById(trainingId);
                LearnerAccount learnerAccount = learnerAccountService.findLearnerById(learnerId);
                if (training == null) {
                    hashMap.put("La formation n'a pas été trouvée", null);
                }
               else { if (learnerAccount == null) {
                    hashMap.put("L'apprenant n'a pas été trouvé", null);
                }
                else {
                    List<TrainingModule> trainingModuleList = learnerAccount.getRegisteredTrainingList();
                    trainingModuleList.add(training);
                    learnerAccount.setRegisteredTrainingList(trainingModuleList);
                    hashMap.put("Formation attribuée à l'apprenant", learnerAccountService.saveLearner(learnerAccount));
                }}
            }catch (Exception e) {
                hashMap.put("Erreur à cause de " + e.getMessage(), null);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hashMap);
            }
            return ResponseEntity.ok(hashMap);
        }


}
