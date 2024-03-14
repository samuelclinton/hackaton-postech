package com.cloudinn.backend.domain.event;

import com.cloudinn.backend.domain.model.Reservation;

public record ReservationConfirmedEvent(Reservation reservation) {
}
