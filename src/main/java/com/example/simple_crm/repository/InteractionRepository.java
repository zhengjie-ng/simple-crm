package com.example.simple_crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simple_crm.entity.Interaction;

public interface InteractionRepository extends JpaRepository<Interaction, Long> {
    
}
