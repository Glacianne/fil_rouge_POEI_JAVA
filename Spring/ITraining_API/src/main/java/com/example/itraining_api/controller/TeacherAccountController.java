package com.example.itraining_api.controller;

import com.example.itraining_api.entity.TeacherAccount;
import com.example.itraining_api.repository.TeacherAccountRepository;
import com.example.itraining_api.service.TeacherAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.itraining_api.entity.TeacherAccount;
import com.example.itraining_api.service.TeacherAccountService;

@RestController
@RequestMapping("/teacherController")
public class TeacherAccountController {

    @Autowired
    private TeacherAccountService teacherAccountService;

    @GetMapping("/teacher")
    public List<TeacherAccount> findAllTeacher() {
        return teacherAccountService.findTeacherAccountList();
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<Map<String, TeacherAccount>> findTeacherById(@PathVariable int id) {
        Map<String, TeacherAccount> hashMap = new HashMap<String, TeacherAccount>();
        try {
            hashMap.put("Formation trouvée", teacherAccountService.findTeacherById(id));
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }

    @PostMapping("/teacher")
    public ResponseEntity<Map<String, TeacherAccount>> createTeacher(@RequestBody TeacherAccount teacherAccount) {
        Map<String, TeacherAccount> hashMap = new HashMap<String, TeacherAccount>();
        try {
            hashMap.put("Prof ajouté", teacherAccountService.saveTeacher(teacherAccount));
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }

    @PutMapping("/teacher/{id}")
    public ResponseEntity<Map<String, TeacherAccount>> updateTeacher(@PathVariable("id") int id,
            @RequestBody TeacherAccount teacherAccount) {
        Map<String, TeacherAccount> hashMap = new HashMap<String, TeacherAccount>();
        try {
            hashMap.put("Prof ajouté", teacherAccountService.updateTeacher(teacherAccount, id));
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }


    @DeleteMapping("/teacher/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("id") int id){
        try{
            teacherAccountService.deleteTeacherById(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception has occured due to " + e.getMessage());
        }
        return ResponseEntity.ok("Prof supprimé");
    }

    }



