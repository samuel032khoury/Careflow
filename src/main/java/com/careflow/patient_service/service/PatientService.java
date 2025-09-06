package com.careflow.patient_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.careflow.patient_service.dto.patient.PatientResponse;
import com.careflow.patient_service.repository.PatientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public List<PatientResponse> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(patient -> new PatientResponse(patient))
                .collect(Collectors.toList());
    }
}
