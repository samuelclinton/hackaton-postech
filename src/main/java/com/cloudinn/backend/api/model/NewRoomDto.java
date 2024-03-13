package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.model.RoomType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class NewRoomDto implements RoomInputDto {

    @NotNull
    private RoomType type;

    @NotNull
    @Positive
    private Integer guestCapacity;

    @NotNull
    @Positive
    private Integer bedAmount;

    @NotBlank
    private String bedType;

    @NotBlank
    private String bathroom;

    @Positive
    private BigDecimal price;

    @NotNull
    @Valid
    private IdRepresentationDto building;

    @NotNull
    @Valid
    private IdRepresentationDto location;

}
