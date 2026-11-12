package com.craft.actormanagement.service;

import com.craft.actormanagement.exception.ActorNotFoundException;
import com.craft.actormanagement.model.Actor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

    private final List<Actor> actors = new ArrayList<>();
    private int nextId = 3; // ids 1 and 2 are already used

    public ActorService() {
        actors.add(new Actor(1, "John Doe", "Silent Harbor"));
        actors.add(new Actor(2, "Jane Smith", "Mystery Island"));
    }

    public List<Actor> getAllActors() {
        return actors;
    }

    // throws ActorNotFoundException when there is no actor with this id
    public Actor getActorById(int id) {
        return findOrThrow(id);
    }

    public Actor createActor(Actor actor) {
        actor.setId(nextId++);
        actors.add(actor);
        return actor;
    }

    // replaces name and movieName
    public Actor updateActor(int id, Actor updated) {
        Actor actor = findOrThrow(id);
        actor.setName(updated.getName());
        actor.setMovieName(updated.getMovieName());
        return actor;
    }

    // changes only the fields that are not null
    public Actor patchActor(int id, Actor changes) {
        Actor actor = findOrThrow(id);
        if (changes.getName() != null) {
            actor.setName(changes.getName());
        }
        if (changes.getMovieName() != null) {
            actor.setMovieName(changes.getMovieName());
        }
        return actor;
    }

    public void deleteActor(int id) {
        Actor actor = findOrThrow(id);
        actors.remove(actor);
    }

    private Actor findOrThrow(int id) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                return actor;
            }
        }
        throw new ActorNotFoundException(id);
    }
}