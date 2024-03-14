package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.InputDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
public class NewReservationDto implements InputDto {

    @NotNull
    @Positive
    private Integer guests;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkin;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkout;

    @NotNull
    @NotEmpty
    @Valid
    private List<IdRepresentationDto> rooms;

    @Valid
    private List<AddedOptionalDto> addedOptionals;

    @NotNull
    @Valid
    private IdRepresentationDto user;

}
