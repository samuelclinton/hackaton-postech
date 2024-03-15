package com.cloudinn.backend.api.controller;

import com.cloudinn.backend.api.model.NewReservationDto;
import com.cloudinn.backend.api.model.ReservationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Reservations")
public interface ReservationController {

    @Operation(
            summary = "Cria uma reserva",
            description = "Cria uma reserva"
    )
    ReservationDto create(NewReservationDto newReservationDto);

    @Operation(
            summary = "Confirma uma reserva",
            description = "Confirma uma reserva"
    )
    ReservationDto confirm(@Parameter(description = "O ID de uma reserva", in = ParameterIn.PATH, example = "1") Long id);

    @Operation(
            summary = "Busca uma reserva",
            description = "Busca uma reserva"
    )
    ReservationDto get(@Parameter(description = "O ID de uma reserva", in = ParameterIn.PATH, example = "1") Long id);

    @Operation(
            summary = "Cancela uma reserva",
            description = "Cancela uma reserva"
    )
    ReservationDto cancel(@Parameter(description = "O ID de uma reserva", in = ParameterIn.PATH, example = "1") Long id);

}
