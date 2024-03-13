package com.cloudinn.backend.domain.exception;

public class RoomNotFoundException extends EntityNotFoundException {

    public RoomNotFoundException(String message) {
        super(message);
    }

}
