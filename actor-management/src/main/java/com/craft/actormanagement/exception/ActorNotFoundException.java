package com.craft.actormanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ActorNotFoundException extends RuntimeException {

    public ActorNotFoundException(int id) {
        super("Actor not found with id " + id);
    }
}