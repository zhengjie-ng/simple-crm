package com.example.simple_crm;

import java.util.List;

public interface InteractionService {
    Interaction createInteraction(Interaction interaction);
    Interaction getInteraction(Long id);
    List<Interaction> getAllInteractions();
    Interaction updateInteraction(Long id, Interaction interaction);
    void deleteInteraction(Long id);
}
