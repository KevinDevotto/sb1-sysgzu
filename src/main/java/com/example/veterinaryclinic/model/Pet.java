package com.example.veterinaryclinic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String breed;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;
}