package com.example.itraining_api.service;

import com.example.itraining_api.entity.LearnerAccount;
import com.example.itraining_api.entity.TeacherAccount;
import com.example.itraining_api.repository.LearnerAccountRepository;
import com.example.itraining_api.repository.TeacherAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherAccountServiceImpl implements TeacherAccountService{
    @Autowired
    private TeacherAccountRepository teacherAccountRepository;

    @Autowired
    private LearnerAccountRepository learnerAccountRepository;

    @Override
    public TeacherAccount saveTeacher(TeacherAccount teacherAccount) {
        return teacherAccountRepository.save(teacherAccount);
    }

    @Override
    public List<TeacherAccount> findTeacherAccountList() {
        return (List<TeacherAccount>)  teacherAccountRepository.findAll();
    }

    @Override
    public TeacherAccount updateTeacher(TeacherAccount teacherAccount, int id) {
       TeacherAccount teacherAccount1 = teacherAccountRepository.findById(id).get();
       return teacherAccountRepository.save(teacherAccount1);
    }

    @Override
    public void deleteTeacherById(int id) {
        teacherAccountRepository.deleteById(id);
    }

    @Override
    public TeacherAccount findTeacherById(int id) {
        return teacherAccountRepository.findById(id).orElse(null);
    }




}
