package com.cloudinn.backend.domain.service;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;

import java.util.Map;

public interface NotificationService {

    void send(Notification notification);

    @Getter
    @Builder
    class Notification {

        @NonNull
        private String receiver;

        @NonNull
        private String subject;

        @NonNull
        private String body;

        @Singular("variable")
        private Map<String, Object> variables;

    }

}
