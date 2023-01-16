package com.example.itraining_api.controller;

import com.example.itraining_api.entity.TeacherAccount;
import com.example.itraining_api.repository.TeacherAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TeacherAccountController {

    @Autowired
    private TeacherAccountRepository teacherAccountRepository;
    @GetMapping("/teacherAccount")
    public List<TeacherAccount> getTeacherAccount(@RequestParam int id) {
        List<TeacherAccount> teacherAccounts = teacherAccountRepository.findTeacherById(id);
        if (teacherAccounts != null) {
            return teacherAccounts;
        } else {
            return null;
        }
    }


}
