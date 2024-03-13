package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.OutputDto;
import com.cloudinn.backend.domain.model.RoomType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class RoomDto implements OutputDto {

    private Long id;
    private RoomType type;
    private Boolean available;
    private Integer guestCapacity;
    private Integer bedAmount;
    private String bedType;
    private String bathroom;
    private BigDecimal price;
    private List<NewFurnitureDto> furniture;
    private BuildingDto building;

}
