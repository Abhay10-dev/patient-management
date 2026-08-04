package com.lazycoder.patientservice.dto;

import com.lazycoder.patientservice.dto.validation.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequestDTO {

    @NotBlank(message = "Patient name is required")
    @Size(min = 2, max = 100, message = "Patient name must be between 2 and 100 characters")
    private String patientName;

    @NotBlank(message = "Patient address is required")
    @Size(min = 2, max = 200, message = "Patient address must be between 2 and 200 characters")
    private String patientAddress;

    @NotBlank(message = "Patient age is required")
    @Min(value = 0, message = "Patient age must be a positive number")
    private int  patientAge;

    @NotBlank(message = "Patient email is required")
    @Email(message = "Patient email is invalid")
    private String patientEmail;

    @NotBlank(message = "Patient phone is required")
    @Size(min = 8, max = 15, message = "Patient phone must be between 8 and 15 characters")
    private String patientPhone;

    @NotBlank(message = "Patient gender is required")
    @Size(min = 2, max = 10, message = "Patient gender must be between 2 and 10 characters")
    private String patientGender;

    @NotBlank(message = "Patient date of birth is required")
    @Size(min = 10, max = 10, message = "Patient date of birth must be in YYYY-MM-DD format")
    private String patientDateOfBirthday;

    @NotBlank(groups = CreatePatientValidationGroup.class, message = "Register date is required")
    @Size(min = 10, max = 10, message = "Register date must be in YYYY-MM-DD format")
    private String registerDate;

}
