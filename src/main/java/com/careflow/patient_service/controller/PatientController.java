package com.careflow.patient_service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careflow.patient_service.dto.patient.PatientRequest;
import com.careflow.patient_service.dto.patient.PatientResponse;
import com.careflow.patient_service.service.PatientService;

import jakarta.validation.Valid;
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

    @PostMapping
    public ResponseEntity<PatientResponse> createPatient(@Valid @RequestBody PatientRequest patientRequest) {
        return ResponseEntity.ok().body(patientService.createPatient(patientRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable String id,
            @Valid @RequestBody PatientRequest patientRequest) {
        return ResponseEntity.ok().body(patientService.updatePatient(UUID.fromString(id), patientRequest));
    }
}
