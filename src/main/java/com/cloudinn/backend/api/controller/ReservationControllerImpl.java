package com.cloudinn.backend.api.controller;

import com.cloudinn.backend.api.model.NewReservationDto;
import com.cloudinn.backend.api.model.ReservationDto;
import com.cloudinn.backend.domain.data.DomainEntityMapperImpl;
import com.cloudinn.backend.domain.model.Reservation;
import com.cloudinn.backend.domain.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationControllerImpl implements ReservationController {

    private final ReservationService reservationService;
    private final DomainEntityMapperImpl<NewReservationDto, ReservationDto, Reservation> reservationMapper;

    public ReservationControllerImpl(ReservationService reservationService,
                                     DomainEntityMapperImpl<NewReservationDto, ReservationDto, Reservation> reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationDto create(@RequestBody @Valid NewReservationDto newReservationDto) {
        var createdReservation = reservationService
                .create(reservationMapper.mapInputToEntity(newReservationDto, Reservation.class));
        return reservationMapper.mapEntityToOutput(createdReservation, ReservationDto.class);
    }

    @Override
    @PutMapping("/{id}/confirm")
    @Transactional
    public ReservationDto confirm(@PathVariable Long id) {
        return reservationMapper.mapEntityToOutput(reservationService.confirm(id), ReservationDto.class);
    }

    @Override
    @GetMapping("/{id}")
    @Transactional
    public ReservationDto get(@PathVariable Long id) {
        return reservationMapper.mapEntityToOutput(reservationService.get(id), ReservationDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void cancel(@PathVariable Long id) {
        reservationService.cancel(id);
    }

}
