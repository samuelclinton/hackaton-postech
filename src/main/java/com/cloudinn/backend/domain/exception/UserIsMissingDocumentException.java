package com.cloudinn.backend.domain.exception;

public class UserIsMissingDocumentException extends BusinessLogicException {

    public UserIsMissingDocumentException(String message) {
        super(message);
    }

}
