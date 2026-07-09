package com.lazycoder.patientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponseDTO {

    private String patientId;

    private String patientName;

    private String patientAddress;

    private String patientEmail;

    private String patientPhone;

    private String patientGender;

    private String patientDateOfBirthday;

}
