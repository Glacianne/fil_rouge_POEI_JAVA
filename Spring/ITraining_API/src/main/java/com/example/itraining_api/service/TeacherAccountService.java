package com.example.itraining_api.service;


import com.example.itraining_api.entity.TeacherAccount;

import java.util.List;
import java.util.Optional;

public interface TeacherAccountService {

    TeacherAccount saveTeacher(TeacherAccount teacherAccount);

    List<TeacherAccount> findTeacherAccountList();

    TeacherAccount updateTeacher(TeacherAccount teacherAccount, int id);

    TeacherAccount deleteTeacherById(int id);


    TeacherAccount findTeacherById(int id);

}
