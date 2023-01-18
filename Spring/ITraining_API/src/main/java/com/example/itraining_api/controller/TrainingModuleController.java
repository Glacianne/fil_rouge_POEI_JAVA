package com.example.itraining_api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
@RestController
@RequestMapping("/trainingModuleController")
public class TrainingModuleController {

    @Autowired
    private TrainingModuleService trainingModuleService;

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
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception has occured due to " + e.getMessage());
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

}
