package com.example.itraining_api.controller;

import com.example.itraining_api.entity.AdministratorAccount;
import com.example.itraining_api.entity.TeacherAccount;
import com.example.itraining_api.service.AdministratorAccountService;
import com.example.itraining_api.service.TeacherAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

import com.example.itraining_api.entity.AdministratorAccount;
import com.example.itraining_api.service.AdministratorAccountService;

@RestController
@RequestMapping("/administratorController")
public class AdministratorAccountController {

    @Autowired
    private AdministratorAccountService administratorAccountService;

    @GetMapping("/administrator")
    public ResponseEntity<Map<String, List<AdministratorAccount>>> findAllAdministrator() {
        Map<String, List<AdministratorAccount>> hashMap = new HashMap<String, List<AdministratorAccount>>();
        try {
            hashMap.put("Catalogue chargé", administratorAccountService.findAdministratorAccountList());
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }

    @GetMapping("/administrator/{id}")
    public ResponseEntity<Map<String, AdministratorAccount>> findAdministratorById(@PathVariable int id) {
        Map<String, AdministratorAccount> hashMap = new HashMap<String, AdministratorAccount>();
        try {
            hashMap.put("Administrateur trouvé", administratorAccountService.findAdministratorById(id));
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }

    @PostMapping("/administrator")
    public ResponseEntity<Map<String, AdministratorAccount>> createAdministrator(
            @RequestBody AdministratorAccount administratorAccount) {
        Map<String, AdministratorAccount> hashMap = new HashMap<String, AdministratorAccount>();
        try {
            hashMap.put("Administrateur ajouté", administratorAccountService.saveAdministrator(administratorAccount));
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }

    @PutMapping("/administrator/{id}")
    public ResponseEntity<Map<String, AdministratorAccount>> updateAdministrator(@PathVariable("id") int id,
            @RequestBody AdministratorAccount administratorAccount) {
        Map<String, AdministratorAccount> hashMap = new HashMap<String, AdministratorAccount>();
        try {
            hashMap.put("Administrateur modifié",
                    administratorAccountService.updateAdministrator(administratorAccount, id));
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }
//ça fonctionne

    @DeleteMapping("/administrator/{id}")
    public ResponseEntity<String> deleteAdministrator(@PathVariable int id){
        try{
            administratorAccountService.deleteAdministratorById(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception has occured due to " + e.getMessage());
        }
        return ResponseEntity.ok("Administrateur supprimé");
    }

    }



