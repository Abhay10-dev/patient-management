package com.lazycoder.patientservice.repository;

import com.lazycoder.patientservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepo extends JpaRepository<Patient, UUID> {
    boolean existsByPatientEmail(String patientEmail);
    boolean existsByPatientEmailAndPatientIdNot(String patientEmail, UUID patientId);
}
