package com.example.veterinaryclinic.service;

import com.example.veterinaryclinic.model.Appointment;
import com.example.veterinaryclinic.model.AppointmentStatus;
import com.example.veterinaryclinic.model.User;
import com.example.veterinaryclinic.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
        appointment.setStatus(AppointmentStatus.PENDING);
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByPetOwner(User petOwner) {
        return appointmentRepository.findByPetOwner(petOwner);
    }

    public List<Appointment> getAppointmentsByVeterinarian(User veterinarian) {
        return appointmentRepository.findByVeterinarian(veterinarian);
    }

    public Appointment updateAppointmentStatus(Long id, AppointmentStatus status) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if (appointment != null) {
            appointment.setStatus(status);
            return appointmentRepository.save(appointment);
        }
        return null;
    }
}