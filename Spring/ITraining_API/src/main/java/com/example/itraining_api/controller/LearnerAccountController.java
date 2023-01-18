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

import com.example.itraining_api.entity.LearnerAccount;
import com.example.itraining_api.service.LearnerAccountService;

@CrossOrigin
@RestController
@RequestMapping("/learnerController")
public class LearnerAccountController {

    @Autowired
    private LearnerAccountService learnerAccountService;

    @GetMapping("/learner")
    public ResponseEntity<Map<String, List<LearnerAccount>>> findAllLearner() {
        Map<String, List<LearnerAccount>> hashMap = new HashMap<String, List<LearnerAccount>>();
        try {
            hashMap.put("Voici tous les étudiants", learnerAccountService.findLearnerAccountList());
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }

    @GetMapping("/learner/{id}")
    public ResponseEntity<Map<String, LearnerAccount>> findLearnerById(@PathVariable int id) {
        Map<String, LearnerAccount> hashMap = new HashMap<String, LearnerAccount>();
        try {
            hashMap.put("Etudiant trouvé", learnerAccountService.findLearnerById(id));
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }

    @PostMapping("/learner")
    public ResponseEntity<Map<String, LearnerAccount>> createLearner(@RequestBody LearnerAccount learnerAccount) {
        Map<String, LearnerAccount> hashMap = new HashMap<String, LearnerAccount>();
        try {
            hashMap.put("Etudiant ajouté", learnerAccountService.saveLearner(learnerAccount));
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }

    @PutMapping("/learner/{id}")
    public ResponseEntity<Map<String, LearnerAccount>> updateLearner(@PathVariable("id") int id,
            @RequestBody LearnerAccount learnerAccount) {
        Map<String, LearnerAccount> hashMap = new HashMap<String, LearnerAccount>();
        try {
            hashMap.put("Etudiant modifié", learnerAccountService.updateLearner(learnerAccount, id));
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }


    @DeleteMapping("/learner/{id}")
    public ResponseEntity<String> deleteLearner(@PathVariable("id") int id){
        try{
            learnerAccountService.deleteLearnerById(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception has occured due to " + e.getMessage());
        }
        return ResponseEntity.ok("Elève supprimé");
    }

}
