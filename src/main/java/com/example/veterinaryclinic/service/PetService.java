package com.example.veterinaryclinic.service;

import com.example.veterinaryclinic.model.Pet;
import com.example.veterinaryclinic.model.User;
import com.example.veterinaryclinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> getPetsByOwner(User owner) {
        return petRepository.findByOwner(owner);
    }

    public Pet getPetById(Long id) {
        return petRepository.findById(id).orElse(null);
    }
}