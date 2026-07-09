package com.lazycoder.patientservice.mapper;

import com.lazycoder.patientservice.dto.PatientRequestDTO;
import com.lazycoder.patientservice.dto.PatientResponseDTO;
import com.lazycoder.patientservice.model.Patient;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PatientMapper {

    private PatientMapper() {
        /* This utility class should not be instantiated */
    }


    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setPatientId(patient.getPatientId().toString());
        patientResponseDTO.setPatientName(patient.getPatientName());
        patientResponseDTO.setPatientGender(patient.getPatientGender());
        patientResponseDTO.setPatientAddress(patient.getPatientAddress());
        patientResponseDTO.setPatientEmail(patient.getPatientEmail());
        patientResponseDTO.setPatientPhone(patient.getPatientPhone());
        patientResponseDTO.setPatientDateOfBirthday(patient.getPatientDateOfBirthday().toString());
        return patientResponseDTO;
    }

    public static Patient toEntity(PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();
        patient.setPatientName(patientRequestDTO.getPatientName());
        patient.setPatientGender(patientRequestDTO.getPatientGender());
        patient.setPatientAddress(patientRequestDTO.getPatientAddress());
        patient.setPatientEmail(patientRequestDTO.getPatientEmail());
        patient.setPatientPhone(patientRequestDTO.getPatientPhone());
        patient.setPatientDateOfBirthday(LocalDate.parse(patientRequestDTO.getPatientDateOfBirthday()));
        patient.setRegisterDate(LocalDate.parse(patientRequestDTO.getRegisterDate()));
        return patient;
    }

}