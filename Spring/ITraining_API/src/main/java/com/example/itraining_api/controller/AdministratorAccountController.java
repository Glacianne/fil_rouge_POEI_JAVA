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

@RestController
public class AdministratorAccountController {

    @Autowired
    private AdministratorAccountService administratorAccountService;


    @GetMapping("/allAdministrator")
    public ResponseEntity<Map<String, List<AdministratorAccount>>> findAllTrainingModule(){
        Map<String, List<AdministratorAccount>> hashMap = new HashMap<String, List<AdministratorAccount>>();
        try{
            hashMap.put ("Catalogue chargé", administratorAccountService.findAdministratorAccountList());
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }
    @GetMapping("/administratorAccount/{id}")
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

    @PostMapping("/addAdministrator")
    public ResponseEntity<Map<String, AdministratorAccount>> saveAdministrator(@RequestBody AdministratorAccount administratorAccount){
    Map<String, AdministratorAccount> hashMap = new HashMap<String, AdministratorAccount>();
    try{
        hashMap.put("Administrateur ajouté", administratorAccountService.saveAdministrator(administratorAccount));
    } catch(Exception e){
        hashMap.put("Erreur à cause de " + e.getMessage(), null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(hashMap);
    }
        return ResponseEntity.ok(hashMap);
    }

    @PutMapping("/updateAdministrator/{id}")
    public ResponseEntity<Map<String, AdministratorAccount>> updateTrainingModule(@PathVariable("id") int id, @RequestBody AdministratorAccount administratorAccount){
        Map<String, AdministratorAccount> hashMap = new HashMap<String, AdministratorAccount>();
        try{
            hashMap.put("Administrateur modifié",administratorAccountService.updateAdministrator(administratorAccount, id));
        } catch (Exception e) {
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(hashMap);
        }
        return ResponseEntity.ok(hashMap);
    }


    @DeleteMapping("/suppressAdministrator/{id}")
    public ResponseEntity<String> deleteAdministrator(@PathVariable("id") int id){
        Map<String, AdministratorAccount> hashMap = new HashMap<String, AdministratorAccount>();
        try{
            hashMap.put("Prof supprimé", administratorAccountService.deleteAdministratorById(id));
        } catch(Exception e){
            hashMap.put("Erreur à cause de " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception has occured due to " + e.getMessage());
        }
        return ResponseEntity.ok("Prof supprimé");
    }

    }



