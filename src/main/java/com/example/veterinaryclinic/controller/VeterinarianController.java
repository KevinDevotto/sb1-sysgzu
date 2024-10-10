package com.example.veterinaryclinic.controller;

import com.example.veterinaryclinic.model.Appointment;
import com.example.veterinaryclinic.model.MedicalRecord;
import com.example.veterinaryclinic.model.User;
import com.example.veterinaryclinic.service.AppointmentService;
import com.example.veterinaryclinic.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarian")
public class VeterinarianController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAppointments(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByVeterinarian(user));
    }

    @PostMapping("/medical-records")
    public ResponseEntity<MedicalRecord> createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return ResponseEntity.ok(medicalRecordService.createMedicalRecord(medicalRecord));
    }
}