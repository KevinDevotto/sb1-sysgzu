package com.example.veterinaryclinic.repository;

import com.example.veterinaryclinic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}