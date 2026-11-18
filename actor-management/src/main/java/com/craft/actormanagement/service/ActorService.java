package com.craft.actormanagement.service;

import com.craft.actormanagement.exception.ActorNotFoundException;
import com.craft.actormanagement.model.Actor;
import com.craft.actormanagement.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Actor getActorById(int id) {
        return actorRepository.findById(id).orElseThrow(() -> new ActorNotFoundException(id));
    }

    public Actor createActor(Actor actor) {
        actor.setId(null); // let MySQL generate the id
        return actorRepository.save(actor);
    }

    public Actor updateActor(int id, Actor updated) {
        Actor actor = getActorById(id);
        actor.setName(updated.getName());
        actor.setMovieName(updated.getMovieName());
        return actorRepository.save(actor);
    }

    public Actor patchActor(int id, Actor changes) {
        Actor actor = getActorById(id);
        if (changes.getName() != null) {
            actor.setName(changes.getName());
        }
        if (changes.getMovieName() != null) {
            actor.setMovieName(changes.getMovieName());
        }
        return actorRepository.save(actor);
    }

    public void deleteActor(int id) {
        if (!actorRepository.existsById(id)) {
            throw new ActorNotFoundException(id);
        }
        actorRepository.deleteById(id);
    }
}