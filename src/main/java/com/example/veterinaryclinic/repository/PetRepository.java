package com.example.veterinaryclinic.repository;

import com.example.veterinaryclinic.model.Pet;
import com.example.veterinaryclinic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByOwner(User owner);
}