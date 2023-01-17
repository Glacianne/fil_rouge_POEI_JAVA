package com.example.itraining_api.service;

import com.example.itraining_api.entity.LearnerAccount;
import java.util.List;
import java.util.Optional;

public interface LearnerAccountService {
    LearnerAccount saveLearner(LearnerAccount learnerAccount);

    List<LearnerAccount> findLearnerAccountList();

    Optional<LearnerAccount> findById(int id);

    LearnerAccount updateLearner(LearnerAccount learnerAccount, int id);

    void deleteLearnerById(int id);
}

