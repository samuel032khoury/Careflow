package com.careflow.patient_service.dto.patient;

import com.careflow.patient_service.model.Patient;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientRequest {
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String address;

    @NotBlank
    private String dateOfBirth;

    public Patient toEntity() {
        var patient = new Patient();
        patient.setName(this.name);
        patient.setEmail(this.email);
        patient.setAddress(this.address);
        patient.setDateOfBirth(java.time.LocalDate.parse(this.dateOfBirth));
        return patient;
    }
}
