package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.model.RoomType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class RoomDto {

    private RoomType type;
    private Integer guests;
    private Integer bedAmount;
    private String bedType;
    private String bathroom;
    private BigDecimal price;
    private List<FurnitureDto> furniture;
    private BuildingIdDto building;

}
