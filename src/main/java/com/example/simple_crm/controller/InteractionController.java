package com.example.simple_crm.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simple_crm.entity.Interaction;
import com.example.simple_crm.exception.InteractionNotFoundException;
import com.example.simple_crm.service.InteractionService;

@RestController
@RequestMapping("/interactions")
public class InteractionController {
    private InteractionService interactionService;

    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Interaction> createInteraction(@RequestBody Interaction interaction) {
        Interaction newInteraction = interactionService.createInteraction(interaction);
        return new ResponseEntity<>(newInteraction, HttpStatus.CREATED);
    }

    // READ
    // Read all
    @GetMapping
    public ResponseEntity<List<Interaction>> getAllInteractions() {
        List<Interaction> allInteractions = interactionService.getAllInteractions();
        return new ResponseEntity<>(allInteractions, HttpStatus.OK);
    }

    // Read one
    @GetMapping("/{id}")
    public ResponseEntity<Interaction> getInteraction(@PathVariable Long id) {
        return new ResponseEntity<>(interactionService.getInteraction(id), HttpStatus.OK);
        // try {
        //     Interaction foundInteraction = interactionService.getInteraction(id);
        //     return new ResponseEntity<>(foundInteraction, HttpStatus.OK);
        // } catch (InteractionNotFoundException e) {
        //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Interaction> updateInteraction(@PathVariable Long id, @RequestBody Interaction interaction) {
        // return new ResponseEntity<>(interactionService.updateInteraction(id, interaction), HttpStatus.OK);
        try {
            Interaction updatedInteraction = interactionService.updateInteraction(id, interaction);
            return new ResponseEntity<>(updatedInteraction, HttpStatus.OK);
        } catch (InteractionNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteInteraction(@PathVariable Long id) {
        
        try {
            interactionService.deleteInteraction(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (InteractionNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
