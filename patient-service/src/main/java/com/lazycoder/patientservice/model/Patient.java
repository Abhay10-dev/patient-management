package com.lazycoder.patientservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID patientId;

    @NotNull
    private String patientName;

    @NotNull
    private String patientAddress;

    @NotNull
    @Email
    @Column(unique = true)
    private String patientEmail;

    @NotNull
    private String patientPhone;

    @NotNull
    private String patientGender;

    @NotNull
    private LocalDate patientDateOfBirthday;

    @NotNull
    private LocalDate registerDate;

}
