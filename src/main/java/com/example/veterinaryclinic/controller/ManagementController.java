package com.example.veterinaryclinic.controller;

import com.example.veterinaryclinic.model.Appointment;
import com.example.veterinaryclinic.model.AppointmentStatus;
import com.example.veterinaryclinic.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/management")
public class ManagementController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @PutMapping("/appointments/{id}")
    public ResponseEntity<Appointment> updateAppointmentStatus(@PathVariable Long id, @RequestParam AppointmentStatus status) {
        return ResponseEntity.ok(appointmentService.updateAppointmentStatus(id, status));
    }
}