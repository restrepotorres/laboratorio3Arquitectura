package com.udea.parcialfinal.controller;

import com.udea.parcialfinal.domain.model.Patient;
import com.udea.parcialfinal.service.patient.PatientServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
@Tag(name = "Clinical history api", description = "Operations for patients")
public class PatientController {

    @Autowired
     PatientServiceImpl patientservice;

    @PostMapping(value = "/save", produces = "application/vnd.patient.v1+json")
        public Patient savePatient(@RequestBody Patient patient) {
        return patientservice.savePatient(patient);
    }



}
