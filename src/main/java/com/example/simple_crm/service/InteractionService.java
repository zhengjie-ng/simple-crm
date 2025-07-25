package com.example.simple_crm.service;

import java.util.List;

import com.example.simple_crm.entity.Interaction;

public interface InteractionService {
    Interaction createInteraction(Interaction interaction);
    Interaction getInteraction(Long id);
    List<Interaction> getAllInteractions();
    Interaction updateInteraction(Long id, Interaction interaction);
    void deleteInteraction(Long id);
}
