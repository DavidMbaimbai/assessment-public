package com.xib.assessment.controller;

import com.xib.assessment.entity.Manager;
import com.xib.assessment.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService){
        this.managerService = managerService;
    }

    @PostMapping
    public ResponseEntity<Manager> saveManager(@RequestBody Manager manager){
        Manager savedManager = managerService.saveNewManager(manager);
        return new ResponseEntity<>(savedManager, HttpStatus.CREATED);
    }
}
