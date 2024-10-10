package com.example.veterinaryclinic.service;

import com.example.veterinaryclinic.model.MedicalRecord;
import com.example.veterinaryclinic.model.Pet;
import com.example.veterinaryclinic.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecord createMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    public List<MedicalRecord> getMedicalRecordsByPet(Pet pet) {
        return medicalRecordRepository.findByPet(pet);
    }
}