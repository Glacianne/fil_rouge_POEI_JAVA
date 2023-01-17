package com.example.itraining_api.controller;

import com.example.itraining_api.entity.TeacherAccount;
import com.example.itraining_api.repository.TeacherAccountRepository;
import com.example.itraining_api.service.TeacherAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TeacherAccountController {

    @Autowired
    private TeacherAccountService teacherAccountService;

   @PostMapping("/teacher")
    public TeacherAccount saveTeacher(@RequestBody TeacherAccount teacherAccount)
    {
        return teacherAccountService.saveTeacher(teacherAccount);
    }

    @PutMapping("/teacher/{id}")
    public TeacherAccount updateTeacher(@RequestBody TeacherAccount teacherAccount, @PathVariable("id") int id){
        return teacherAccountService.updateTeacher(teacherAccount, id);
    }

    @DeleteMapping("/teacher/{id}")
    public String deleteTeacher(@RequestBody TeacherAccount teacherAccount, @PathVariable("id") int id){
         teacherAccountService.deleteTeacherById(id);
        return "Suppression réussie";
    }

    }



