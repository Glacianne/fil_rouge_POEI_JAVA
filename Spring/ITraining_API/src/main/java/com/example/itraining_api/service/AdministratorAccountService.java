package com.example.itraining_api.service;

import java.util.List;

import com.example.itraining_api.entity.AdministratorAccount;

public interface AdministratorAccountService {

    AdministratorAccount saveAdministrator(AdministratorAccount administratorAccount);

    List<AdministratorAccount> findAdministratorAccountList();

    AdministratorAccount updateAdministrator(AdministratorAccount administratorAccount, int id);

    AdministratorAccount deleteAdministratorById(int id);

    AdministratorAccount findAdministratorById(int id);

}
