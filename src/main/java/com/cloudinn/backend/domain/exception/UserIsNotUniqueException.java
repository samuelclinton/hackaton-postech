package com.cloudinn.backend.domain.exception;

public class UserIsNotUniqueException extends BusinessLogicException {

    public UserIsNotUniqueException(String message) {
        super(message);
    }

}
