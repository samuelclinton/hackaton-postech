package com.cloudinn.backend.api.model;

import com.cloudinn.backend.api.model.room.RoomSummaryDto;
import com.cloudinn.backend.api.model.user.UserSummaryDto;
import com.cloudinn.backend.domain.data.OutputDto;
import com.cloudinn.backend.domain.model.ReservationStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ReservationDto implements OutputDto {

    private Long id;
    private ReservationStatus status;
    private LocalDateTime creationDate;
    private Integer guests;
    private LocalDate checkin;
    private LocalDate checkout;
    private BigDecimal subtotal;
    private List<RoomSummaryDto> rooms;
    private List<AddedOptionalDto> addedOptionals;
    private UserSummaryDto user;

}
