package com.example.itraining_api.service;


import com.example.itraining_api.entity.AdministratorAccount;
import com.example.itraining_api.entity.TeacherAccount;

import java.util.List;

public interface AdministratorAccountService {

    AdministratorAccount saveAdministrator(AdministratorAccount administratorAccount);

    List<AdministratorAccount> findAdministratorAccountList();

    AdministratorAccount updateAdministrator(AdministratorAccount administratorAccount, int id);

    void deleteAdministratorById(int id);

    AdministratorAccount findAdministratorById(int id);

}
