package com.cloudinn.backend.api.model;

import com.cloudinn.backend.api.model.room.RoomSummaryDto;
import com.cloudinn.backend.api.model.user.UserSummaryDto;
import com.cloudinn.backend.domain.data.OutputDto;
import com.cloudinn.backend.domain.model.ReservationStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ReservationDto implements OutputDto {

    @Schema(example = "1")
    private Long id;

    private ReservationStatus status;

    @Schema(example = "2024-12-23T10:15:30")
    private LocalDateTime creationDate;

    @Schema(example = "2")
    private Integer guests;

    @Schema(example = "2024-03-13")
    private LocalDate checkin;

    @Schema(example = "2024-03-15")
    private LocalDate checkout;

    @Schema(example = "309.89")
    private BigDecimal subtotal;

    private List<RoomSummaryDto> rooms;
    private List<AddedOptionalDto> addedOptionals;
    private UserSummaryDto user;

}
