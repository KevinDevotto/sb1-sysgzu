package com.example.veterinaryclinic.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "medical_records")
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "veterinarian_id", nullable = false)
    private User veterinarian;

    @Column(nullable = false)
    private LocalDateTime recordDate;

    @Column(nullable = false, length = 1000)
    private String diagnosis;

    @Column(nullable = false, length = 1000)
    private String treatment;
}