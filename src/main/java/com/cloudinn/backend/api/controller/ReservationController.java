package com.cloudinn.backend.api.controller;

import com.cloudinn.backend.api.model.NewReservationDto;
import com.cloudinn.backend.api.model.ReservationDto;

public interface ReservationController {

    ReservationDto create(NewReservationDto newReservationDto);
    ReservationDto confirm(Long id);
    ReservationDto get(Long id);
    void cancel(Long id);

}
