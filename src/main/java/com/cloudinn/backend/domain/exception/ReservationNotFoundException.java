package com.cloudinn.backend.domain.exception;

public class ReservationNotFoundException extends EntityNotFoundException {

    public ReservationNotFoundException(String message) {
        super(message);
    }

}
