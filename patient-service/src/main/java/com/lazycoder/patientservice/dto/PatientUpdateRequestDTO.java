package com.lazycoder.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientUpdateRequestDTO {

    @Size(min = 2, max = 100, message = "Patient name must be between 2 and 100 characters")
    private String patientName;

    @Size(min = 2, max = 200, message = "Patient address must be between 2 and 200 characters")
    private String patientAddress;

    @Min(value = 0, message = "Patient age must be a positive number")
    @Max(value = 120, message = "Patient age must be less than or equal to 120")
    private int patientAge;

    @Email(message = "Patient email is invalid")
    private String patientEmail;

    @Size(min = 8, max = 15, message = "Patient phone must be between 8 and 15 characters")
    private String patientPhone;

    @Size(min = 2, max = 10, message = "Patient gender must be between 2 and 10 characters")
    private String patientGender;

    @Size(min = 10, max = 10, message = "Patient date of birth must be in YYYY-MM-DD format")
    private String patientDateOfBirthday;

    @Size(min = 10, max = 10, message = "Register date must be in YYYY-MM-DD format")
    private String registerDate;

}
