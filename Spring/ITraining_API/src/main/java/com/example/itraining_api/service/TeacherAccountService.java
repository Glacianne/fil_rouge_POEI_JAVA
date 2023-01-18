package com.example.itraining_api.service;

import java.util.List;

import com.example.itraining_api.entity.TeacherAccount;

public interface TeacherAccountService {

    TeacherAccount saveTeacher(TeacherAccount teacherAccount);

    List<TeacherAccount> findTeacherAccountList();

    TeacherAccount updateTeacher(TeacherAccount teacherAccount, int id);

    void deleteTeacherById(int id);

    TeacherAccount findTeacherById(int id);

}
