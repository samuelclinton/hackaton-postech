package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.model.RoomType;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateRoomDto implements RoomInputDto {

    private RoomType type;

    @Positive
    private Integer guestCapacity;

    @Positive
    private Integer bedAmount;

    private String bedType;
    private String bathroom;

    @Positive
    private BigDecimal price;

}
