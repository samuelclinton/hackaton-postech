package com.cloudinn.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoomType {

    STANDARD("Standard"),
    DOUBLE_STANDARD("Double Standard"),
    PREMIUM("Premium"),
    DOUBLE_PREMIUM("Double Premium");

    private final String formattedType;

}
