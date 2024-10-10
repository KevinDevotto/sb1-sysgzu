package com.example.veterinaryclinic.controller;

import com.example.veterinaryclinic.model.Appointment;
import com.example.veterinaryclinic.model.Pet;
import com.example.veterinaryclinic.model.User;
import com.example.veterinaryclinic.service.AppointmentService;
import com.example.veterinaryclinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class PetOwnerController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PetService petService;

    @PostMapping("/appointments")
    public ResponseEntity<Appointment> requestAppointment(@RequestBody Appointment appointment, @AuthenticationPrincipal User user) {
        appointment.setPetOwner(user);
        return ResponseEntity.ok(appointmentService.createAppointment(appointment));
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAppointments(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByPetOwner(user));
    }

    @GetMapping("/pets")
    public ResponseEntity<List<Pet>> getPets(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(petService.getPetsByOwner(user));
    }
}