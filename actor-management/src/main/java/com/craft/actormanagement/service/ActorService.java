package com.craft.actormanagement.service;

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

    // returns null when there is no actor with this id
    public Actor getActorById(int id) {
        return findById(id);
    }

    public Actor createActor(Actor actor) {
        actor.setId(nextId++);
        actors.add(actor);
        return actor;
    }

    // replaces name and movieName; returns null when the id does not exist
    public Actor updateActor(int id, Actor updated) {
        Actor actor = findById(id);
        if (actor == null) {
            return null;
        }
        actor.setName(updated.getName());
        actor.setMovieName(updated.getMovieName());
        return actor;
    }

    // changes only the fields that are not null; returns null when the id does not exist
    public Actor patchActor(int id, Actor changes) {
        Actor actor = findById(id);
        if (actor == null) {
            return null;
        }
        if (changes.getName() != null) {
            actor.setName(changes.getName());
        }
        if (changes.getMovieName() != null) {
            actor.setMovieName(changes.getMovieName());
        }
        return actor;
    }

    // returns true when an actor was removed
    public boolean deleteActor(int id) {
        return actors.removeIf(actor -> actor.getId() == id);
    }

    private Actor findById(int id) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                return actor;
            }
        }
        return null;
    }
}