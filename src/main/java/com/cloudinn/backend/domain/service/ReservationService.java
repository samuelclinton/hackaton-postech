package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.domain.model.AddedOptional;
import com.cloudinn.backend.domain.model.Reservation;

public interface ReservationService {

    Reservation create(Reservation reservation);
    Reservation confirm(Long id);
    Reservation cancel(Long id);
    Reservation get(Long id);

    AddedOptional getAddedOptional(Long id);

}
