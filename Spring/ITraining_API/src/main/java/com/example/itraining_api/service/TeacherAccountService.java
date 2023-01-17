package com.example.itraining_api.service;

import com.example.itraining_api.entity.TeacherAccount;

import java.util.List;

public interface TeacherAccountService {

    TeacherAccount saveTeacher(TeacherAccount teacherAccount);

    List<TeacherAccount> findTeacherAccountList();

    TeacherAccount updateTeacher(TeacherAccount teacherAccount, int id);

    void deleteTeacherById(int id);
}
