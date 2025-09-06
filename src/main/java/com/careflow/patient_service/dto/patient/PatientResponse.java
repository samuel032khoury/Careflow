package com.careflow.patient_service.dto.patient;

import com.careflow.patient_service.model.Patient;

import lombok.Data;

@Data
public class PatientResponse {

    private String id;
    private String name;
    private String email;
    private String address;
    private String dateOfBirth;

    public PatientResponse(Patient patient) {
        this.id = patient.getId().toString();
        this.name = patient.getName();
        this.email = patient.getEmail();
        this.address = patient.getAddress();
        this.dateOfBirth = patient.getDateOfBirth().toString();
    }
}
