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
    public ResponseEntity<Actor> getActorById(@PathVariable int id) {
        Actor actor = actorService.getActorById(id);
        if (actor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actor);
    }

    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(actorService.createActor(actor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable int id, @RequestBody Actor updated) {
        Actor actor = actorService.updateActor(id, updated);
        if (actor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actor);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Actor> patchActor(@PathVariable int id, @RequestBody Actor changes) {
        Actor actor = actorService.patchActor(id, changes);
        if (actor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable int id) {
        if (actorService.deleteActor(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}