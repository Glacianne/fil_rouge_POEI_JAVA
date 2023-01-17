package com.example.itraining_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.itraining_api.entity.LearnerAccount;
import com.example.itraining_api.repository.LearnerAccountRepository;

@Service
public class LearnerAccountServiceImpl implements LearnerAccountService {
    @Autowired
    private LearnerAccountRepository learnerAccountRepository;

    @Override
    public LearnerAccount saveLearner(LearnerAccount learnerAccount) {
        return learnerAccountRepository.save(learnerAccount);
    }

    @Override
    public List<LearnerAccount> findLearnerAccountList() {
        return (List<LearnerAccount>) learnerAccountRepository.findAll();
    }

    @Override
    public LearnerAccount findLearnerById(int id) {
        return learnerAccountRepository.findById(id).orElse(null);
    }

    @Override
    public LearnerAccount updateLearner(LearnerAccount learnerAccount, int id) {
        LearnerAccount learnerAccount1 = learnerAccountRepository.findById(id).get();
        return learnerAccountRepository.save(learnerAccount1);
    }

    @Override
    public LearnerAccount deleteLearnerById(int id) {
        learnerAccountRepository.deleteById(id);
        return null;
    }
}
