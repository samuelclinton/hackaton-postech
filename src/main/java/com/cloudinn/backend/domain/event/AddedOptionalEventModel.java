package com.cloudinn.backend.domain.event;

import java.math.BigDecimal;

public record AddedOptionalEventModel(String name, BigDecimal price) {
}
