package com.careflow.patient_service.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.careflow.patient_service.dto.patient.PatientRequest;
import com.careflow.patient_service.dto.patient.PatientResponse;
import com.careflow.patient_service.exception.EmailAlreadyExistsException;
import com.careflow.patient_service.exception.PatientNotFoundException;
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

    public PatientResponse createPatient(PatientRequest patientRequest) {
        if (patientRepository.existsByEmail(patientRequest.getEmail())) {
            throw new EmailAlreadyExistsException(
                    "A patient with this email already exists: " + patientRequest.getEmail());
        }
        var patient = patientRepository.save(patientRequest.toEntity());
        return new PatientResponse(patient);
    }

    public PatientResponse updatePatient(UUID id, PatientRequest patientRequest) {
        var existingPatient = patientRepository.findById(id)
                .orElseThrow(PatientNotFoundException::new);
        existingPatient.setName(patientRequest.getName());
        existingPatient.setEmail(patientRequest.getEmail());
        existingPatient.setAddress(patientRequest.getAddress());
        existingPatient.setDateOfBirth(java.time.LocalDate.parse(patientRequest.getDateOfBirth()));
        var updatedPatient = patientRepository.save(existingPatient);
        return new PatientResponse(updatedPatient);
    }
}
