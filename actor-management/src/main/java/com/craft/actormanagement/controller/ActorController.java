package com.craft.actormanagement.controller;

import com.craft.actormanagement.model.Actor;
import com.craft.actormanagement.service.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/actor")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable int id) {
        return actorService.getActorById(id);
    }

    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(actorService.createActor(actor));
    }

    @PutMapping("/{id}")
    public Actor updateActor(@PathVariable int id, @RequestBody Actor updated) {
        return actorService.updateActor(id, updated);
    }

    @PatchMapping("/{id}")
    public Actor patchActor(@PathVariable int id, @RequestBody Actor changes) {
        return actorService.patchActor(id, changes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable int id) {
        actorService.deleteActor(id);
        return ResponseEntity.noContent().build();
    }
}