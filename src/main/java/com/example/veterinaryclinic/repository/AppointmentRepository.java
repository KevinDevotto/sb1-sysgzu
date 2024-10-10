package com.example.veterinaryclinic.repository;

import com.example.veterinaryclinic.model.Appointment;
import com.example.veterinaryclinic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPetOwner(User petOwner);
    List<Appointment> findByVeterinarian(User veterinarian);
}