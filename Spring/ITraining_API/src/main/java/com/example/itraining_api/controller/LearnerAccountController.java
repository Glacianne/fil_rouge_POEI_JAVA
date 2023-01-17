package com.example.itraining_api.controller;

import com.example.itraining_api.entity.LearnerAccount;
import com.example.itraining_api.repository.LearnerAccountRepository;
import com.example.itraining_api.service.LearnerAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LearnerAccountController {

    @Autowired
    private LearnerAccountRepository learnerAccountRepository;

    @Autowired
    private LearnerAccountService learnerAccountService;

    @GetMapping("/learnerAccount/{id}")
    public Optional<LearnerAccount> findLearner(@RequestBody LearnerAccount learnerAccount, @PathVariable("id") int id){
        return learnerAccountService.findById(id);
    }
    @GetMapping("/learner")
    public List<LearnerAccount> findTeacherAccountList()
    {
        return learnerAccountService.findLearnerAccountList();
    }

    @PostMapping("/learner")
    public LearnerAccount saveLearner(@RequestBody LearnerAccount learnerAccount)
    {
        return learnerAccountService.saveLearner(learnerAccount);
    }

    @PutMapping("/learner/{id}")
    public LearnerAccount updateLearner(@RequestBody LearnerAccount learnerAccount, @PathVariable("id") int id){
        return learnerAccountService.updateLearner(learnerAccount, id);
    }

    @DeleteMapping("/learner/{id}")
    public String deleteLearner(@RequestBody LearnerAccount learnerAccount, @PathVariable("id") int id){
        learnerAccountService.deleteLearnerById(id);
        return "Suppression reussie";
    }
}
