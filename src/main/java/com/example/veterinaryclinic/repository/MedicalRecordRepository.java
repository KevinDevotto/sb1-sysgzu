package com.example.veterinaryclinic.repository;

import com.example.veterinaryclinic.model.MedicalRecord;
import com.example.veterinaryclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    List<MedicalRecord> findByPet(Pet pet);
}