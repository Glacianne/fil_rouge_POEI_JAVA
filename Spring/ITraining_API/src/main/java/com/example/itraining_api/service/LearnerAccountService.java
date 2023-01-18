package com.example.itraining_api.service;

import java.util.List;

import com.example.itraining_api.entity.LearnerAccount;

public interface LearnerAccountService {
    LearnerAccount saveLearner(LearnerAccount learnerAccount);

    List<LearnerAccount> findLearnerAccountList();

    LearnerAccount findLearnerById(int id);

    LearnerAccount updateLearner(LearnerAccount learnerAccount, int id);

    void deleteLearnerById(int id);
}
