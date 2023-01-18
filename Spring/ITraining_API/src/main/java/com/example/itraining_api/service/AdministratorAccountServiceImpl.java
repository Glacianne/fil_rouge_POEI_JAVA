package com.example.itraining_api.service;

import com.example.itraining_api.entity.AdministratorAccount;

import com.example.itraining_api.entity.TeacherAccount;
import com.example.itraining_api.repository.AdministratorAccountRepository;
import com.example.itraining_api.repository.LearnerAccountRepository;
import com.example.itraining_api.repository.TeacherAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorAccountServiceImpl implements AdministratorAccountService{
    @Autowired
    private AdministratorAccountRepository administratorAccountRepository;


    @Override
    public AdministratorAccount saveAdministrator(AdministratorAccount administratorAccount) {
        return administratorAccountRepository.save(administratorAccount);
    }

    @Override
    public List<AdministratorAccount> findAdministratorAccountList() {
        return (List<AdministratorAccount>)  administratorAccountRepository.findAll();
    }

    @Override
    public AdministratorAccount updateAdministrator(AdministratorAccount administratorAccount, int id) {
        AdministratorAccount administratorAccount1 = administratorAccountRepository.findById(id).get();
        return administratorAccountRepository.save(administratorAccount1);
    }

    @Override
    public void deleteAdministratorById(int id) {
        administratorAccountRepository.deleteById(id);

    }

    @Override
    public AdministratorAccount findAdministratorById(int id) {
        return administratorAccountRepository.findById(id).orElse(null);
    }
}
