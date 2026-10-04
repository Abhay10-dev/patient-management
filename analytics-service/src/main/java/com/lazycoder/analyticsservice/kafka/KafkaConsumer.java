package com.lazycoder.analyticsservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.event.PatientCreatedEvent;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "patient", groupId = "analytics-service")
    public void consumeEvent(byte[] eventBytes) {
        try {
            PatientCreatedEvent event = PatientCreatedEvent.parseFrom(eventBytes);

            log.info("Patient Created Event Received: PatientId{}, PatientName{}, PatientEmail{}, EventType{}",
                    event.getPatientId(), event.getName(), event.getEmail(), event.getEventType());

        } catch (InvalidProtocolBufferException e) {
            log.error("Failed to parse PatientCreatedEvent: {}", e.getMessage(), e);
        }
    }
}
