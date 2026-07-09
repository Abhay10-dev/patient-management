package com.lazycoder.patientservice.service;

import com.lazycoder.patientservice.dto.PatientRequestDTO;
import com.lazycoder.patientservice.dto.PatientResponseDTO;
import com.lazycoder.patientservice.dto.PatientUpdateRequestDTO;
import com.lazycoder.patientservice.exception.EmailAlreadyExistsException;
import com.lazycoder.patientservice.exception.ResourceNotFoundException;
import com.lazycoder.patientservice.mapper.PatientMapper;
import com.lazycoder.patientservice.model.Patient;
import com.lazycoder.patientservice.repository.PatientRepo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepo patientRepo;

    @Autowired
    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patients = patientRepo.findAll();

        return patients.stream()
                .map(PatientMapper::toDTO)
                .toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {

        if (patientRepo.existsByPatientEmail(patientRequestDTO.getPatientEmail())) {
            throw new EmailAlreadyExistsException("Patient with email "
                    + patientRequestDTO.getPatientEmail() + " already exists");
        }

        // convert patientRequestDTO to Patient entity
        Patient patient = PatientMapper.toEntity(patientRequestDTO);

        // save the patient entity to the database
        patientRepo.save(patient);

        // convert Patient entity to patientResponseDTO and return
        return PatientMapper.toDTO(patient);
    }

    @Transactional
    public PatientResponseDTO updatePatient(UUID patientId, @Valid PatientUpdateRequestDTO dto) {

        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + patientId));

        if (dto.getPatientEmail() != null
                && !dto.getPatientEmail().equalsIgnoreCase(patient.getPatientEmail())
                && patientRepo.existsByPatientEmailAndPatientIdNot(dto.getPatientEmail(), patientId)) {
            throw new EmailAlreadyExistsException("Patient with email "
                    + dto.getPatientEmail() + " already exists");
        }

        if (dto.getPatientName() != null) {
            patient.setPatientName(dto.getPatientName());
        }
        if (dto.getPatientEmail() != null) {
            patient.setPatientEmail(dto.getPatientEmail());
        }
        if (dto.getPatientAddress() != null) {
            patient.setPatientAddress(dto.getPatientAddress());
        }
        if (dto.getPatientGender() != null) {
            patient.setPatientGender(dto.getPatientGender());
        }
        if (dto.getPatientPhone() != null) {
            patient.setPatientPhone(dto.getPatientPhone());
        }
        if (dto.getPatientDateOfBirthday() != null) {
            patient.setPatientDateOfBirthday(LocalDate.parse(dto.getPatientDateOfBirthday()));
        }
        if (dto.getRegisterDate() != null) {
            patient.setRegisterDate(LocalDate.parse(dto.getRegisterDate()));
        }

        return PatientMapper.toDTO(patient);
    }

    public void deletePatient(UUID patientId) {
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + patientId));

        patientRepo.delete(patient);
    }
}
