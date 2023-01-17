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

@RestController
public class TeacherAccountController {

    @Autowired
    private TeacherAccountService teacherAccountService;



    @PutMapping("/teacher")
    public List<TeacherAccount> findTeacherAccountList(){
        return teacherAccountService.findTeacherAccountList();
    }

    @GetMapping("/teacherAccount/{id}")
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
    @PostMapping("/ajouterTeacher")
    public ResponseEntity<Map<String, TeacherAccount>> saveTeacher(@RequestBody TeacherAccount teacherAccount){
    Map<String, TeacherAccount> hashMap = new HashMap<String, TeacherAccount>();
    try{
        hashMap.put("Prof ajouté",teacherAccountService.saveTeacher(teacherAccount));
    } catch(Exception e){
        hashMap.put("Erreur à cause de " + e.getMessage(), null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(hashMap);
    }
        return ResponseEntity.ok(hashMap);
    }

    @PutMapping("/updateTeacher/{id}")
    public ResponseEntity<Map<String, TeacherAccount>> updateTrainingModule(@PathVariable("id") int id, @RequestBody TeacherAccount teacherAccount){
        Map<String, TeacherAccount> hashMap = new HashMap<String, TeacherAccount>();
        try{
            hashMap.put("Prof ajouté",teacherAccountService.updateTeacher(teacherAccount, id));
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }


    @DeleteMapping("/suppressTeacher/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("id") int id){
        Map<String, TeacherAccount> hashMap = new HashMap<String, TeacherAccount>();
        try{
            hashMap.put("Prof supprimé", teacherAccountService.deleteTeacherById(id));
        } catch(Exception e){
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception has occured due to " + e.getMessage());
        }
        return ResponseEntity.ok("Prof supprimé");
    }

    }



