package com.example.simple_crm;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class InteractionServiceImpl implements InteractionService {
    private InteractionRepository interactionRepository;

    public InteractionServiceImpl(InteractionRepository interactionRepository) {
        this.interactionRepository = interactionRepository;
    }

    // CRUD
    // Create
    @Override
    public Interaction createInteraction(Interaction interaction) {
        return interactionRepository.save(interaction);
    }

    // Read
    // Read one
    @Override
    public Interaction getInteraction(Long id) {
        // Interaction foundInteraction = interactionRepository.findById(id).get();

        // return foundInteraction;
        return interactionRepository.findById(id).orElseThrow(() -> new InteractionNotFoundException(id));

    }

    // Read all
    @Override
    public List<Interaction> getAllInteractions() {
        System.out.println("1️⃣ InteractionServiceImpl.getAllInteractions() called");
        List<Interaction> allInteractions = interactionRepository.findAll();
        return allInteractions;
    }

    // Update
    @Override
    public Interaction updateInteraction(Long id, Interaction interaction) {
        Interaction interactionToUpdate = interactionRepository.findById(id)
                .orElseThrow(() -> new InteractionNotFoundException(id));
        interactionToUpdate.setRemarks(interaction.getRemarks());
        interactionToUpdate.setInteractionDate(interaction.getInteractionDate());
        return interactionRepository.save(interactionToUpdate);

        // Optional<Interaction> optionalInteraction =
        // interactionRepository.findById(id);
        // if (optionalInteraction.isPresent()) {
        // Interaction foundInteraction = optionalInteraction.get();
        // foundInteraction.setRemarks(interaction.getRemarks());
        // foundInteraction.setInteractionDate(interaction.getInteractionDate());
        // return interactionRepository.save(foundInteraction);
        // }
        // throw new InteractionNotFoundException(id);

        // // Retrieve the interaction from the database
        // Interaction interactionToUpdate = interactionRepository.findById(id).get();
        // // Update the fields of the interaction retrieved
        // interactionToUpdate.setRemarks(interaction.getRemarks());
        // interactionToUpdate.setInteractionDate(interaction.getInteractionDate());
        // // Save the updated interaction back to the database
        // return interactionRepository.save(interactionToUpdate);

    }

    // Delete
    @Override
    public void deleteInteraction(Long id) {
        Optional<Interaction> optionalInteraction = interactionRepository.findById(id);
        if (optionalInteraction.isPresent()) {
            interactionRepository.deleteById(id);

        }
        throw new InteractionNotFoundException(id);
    }

}
