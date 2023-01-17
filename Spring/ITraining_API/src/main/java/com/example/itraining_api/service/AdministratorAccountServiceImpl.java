package com.example.itraining_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.itraining_api.entity.AdministratorAccount;
import com.example.itraining_api.repository.AdministratorAccountRepository;

@Service
public class AdministratorAccountServiceImpl implements AdministratorAccountService {
    @Autowired
    private AdministratorAccountRepository administratorAccountRepository;

    @Override
    public AdministratorAccount saveAdministrator(AdministratorAccount administratorAccount) {
        return administratorAccountRepository.save(administratorAccount);
    }

    @Override
    public List<AdministratorAccount> findAdministratorAccountList() {
        return (List<AdministratorAccount>) administratorAccountRepository.findAll();
    }

    @Override
    public AdministratorAccount updateAdministrator(AdministratorAccount administratorAccount, int id) {
        AdministratorAccount administratorAccount1 = administratorAccountRepository.findById(id).get();
        return administratorAccountRepository.save(administratorAccount1);
    }

    @Override
    public AdministratorAccount deleteAdministratorById(int id) {
        administratorAccountRepository.deleteById(id);
        return null;
    }

    @Override
    public AdministratorAccount findAdministratorById(int id) {
        return administratorAccountRepository.findById(id).orElse(null);
    }
}
