package com.example.itraining_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.itraining_api.entity.LearnerAccount;
import com.example.itraining_api.entity.TeacherAccount;
import com.example.itraining_api.entity.UserAccount;
import com.example.itraining_api.repository.LearnerAccountRepository;

@RestController
public class LoginController {

    @Autowired
    private LearnerAccountRepository learnerAccountRepository;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    // @PostMapping("/createTeacherAccount")
    // public ResponseEntity<String> createTeaxcherAccount(@RequestBody TeacherAccount teacherAccount) {
    //     UserAccount savedUser = null;
    //     ResponseEntity<String> response = null;
    //     try {
    //         // String hashPwd = passwordEncoder.encode(teacherAccount.getPassword());
    //         // teacherAccount.setPassword(hashPwd);
    //         savedUser = teacherAccountRepository.save(teacherAccount);
    //         if (savedUser.getId() > 0) {
    //             response = ResponseEntity.status(HttpStatus.CREATED).body("User has succefully been created");
    //         }
    //     } catch (Exception e) {
    //         response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    //                 .body("An exception has occured due to " + e.getMessage());
    //     }
    //     return response;
    // }

  /*  @PostMapping("/createLearnerAccount")
    public ResponseEntity<String> createLearnerAccount(@RequestBody LearnerAccount learnerAccount) {
        UserAccount savedUser = null;
        ResponseEntity<String> response = null;
        try {
            // String hashPwd = passwordEncoder.encode(teacherAccount.getPassword());
            // teacherAccount.setPassword(hashPwd);
            savedUser = learnerAccountRepository.save(learnerAccount);
            if (savedUser.getId() > 0) {
                response = ResponseEntity.status(HttpStatus.CREATED).body("Learner account has succefully been created");
            }
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception has occured due to " + e.getMessage());
        }
        return response;
    }*/

    // @PostMapping("/login")
    // public ResponseEntity<String> loginUser(@RequestParam String email,
    // @RequestParam String password){
    // // TODO
    // }

}