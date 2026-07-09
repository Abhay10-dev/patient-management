package com.lazycoder.patientservice.controller;

import com.lazycoder.patientservice.dto.PatientRequestDTO;
import com.lazycoder.patientservice.dto.PatientResponseDTO;
import com.lazycoder.patientservice.dto.PatientUpdateRequestDTO;
import com.lazycoder.patientservice.dto.validation.CreatePatientValidationGroup;
import com.lazycoder.patientservice.service.PatientService;
import jakarta.validation.Valid;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> createPatient(
            @Validated({Builder.Default.class, CreatePatientValidationGroup.class})
            @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO patient = patientService.createPatient(patientRequestDTO);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID patientId, @Valid @RequestBody PatientUpdateRequestDTO patientUpdateRequestDTO) {
        PatientResponseDTO updatedPatient = patientService.updatePatient(patientId, patientUpdateRequestDTO);
        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID patientId) {
        patientService.deletePatient(patientId);
        return ResponseEntity.noContent().build();
    }
}
