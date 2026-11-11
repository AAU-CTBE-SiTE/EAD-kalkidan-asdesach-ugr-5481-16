package com.craft.actormanagement.controller;

import com.craft.actormanagement.model.Actor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/actor")
public class ActorController {

    private final List<Actor> actors = new ArrayList<>();
    private int nextId = 3; // NEW: ids 1 and 2 are already used

    public ActorController() {
        actors.add(new Actor(1, "John Doe", "Silent Harbor"));
        actors.add(new Actor(2, "Jane Smith", "Mystery Island"));
    }

    // GET all actors
    @GetMapping
    public List<Actor> getAllActors() {
        return actors;
    }

    // GET one actor by id
    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable int id) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                return ResponseEntity.ok(actor);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // NEW: POST - create an actor
    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor) {
        actor.setId(nextId++);
        actors.add(actor);
        return ResponseEntity.status(HttpStatus.CREATED).body(actor);
    }
}