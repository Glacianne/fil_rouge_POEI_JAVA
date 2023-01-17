package com.example.itraining_api.service;

import com.example.itraining_api.entity.AdministratorAccount;
import com.example.itraining_api.entity.LearnerAccount;
import java.util.List;
import java.util.Optional;

public interface LearnerAccountService {
    LearnerAccount saveLearner(LearnerAccount learnerAccount);

    List<LearnerAccount> findLearnerAccountList();

    LearnerAccount findLearnerById(int id);

    LearnerAccount updateLearner(LearnerAccount learnerAccount, int id);

    LearnerAccount deleteLearnerById(int id);
}

