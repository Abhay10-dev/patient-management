package com.lazycoder.patientservice.kafka;

import com.lazycoder.patientservice.model.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patient.event.PatientCreatedEvent;

@Slf4j
@Service
public class KafkaProducer {
    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(Patient patient) {
        PatientCreatedEvent event = PatientCreatedEvent.newBuilder()
                .setPatientId(patient.getPatientId().toString())
                .setName(patient.getPatientName())
                .setEmail(patient.getPatientEmail())
                .setEventType("PATIENT_CREATED")
                .build();

        try {
            kafkaTemplate.send("patient", event.toByteArray());
        } catch (Exception e) {
            log.error("Failed to send event to Kafka: {}", e.getMessage(), e);
        }
    }
}
