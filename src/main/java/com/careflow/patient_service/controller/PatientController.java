package com.careflow.patient_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careflow.patient_service.dto.patient.PatientResponse;
import com.careflow.patient_service.service.PatientService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatients() {
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }
}
