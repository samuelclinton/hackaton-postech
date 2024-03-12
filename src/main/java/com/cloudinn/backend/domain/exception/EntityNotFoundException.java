package com.cloudinn.backend.domain.exception;

public abstract class EntityNotFoundException extends RuntimeException {

    protected EntityNotFoundException(String message) {
        super(message);
    }

}
