package com.cloudinn.backend.api.model.room;

import com.cloudinn.backend.api.model.BuildingDto;
import com.cloudinn.backend.api.model.location.LocationSummaryDto;
import com.cloudinn.backend.domain.data.OutputDto;
import com.cloudinn.backend.domain.model.RoomType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class RoomDto implements OutputDto {

    @Schema(example = "1")
    private Long id;

    private RoomType type;

    @Schema(example = "2")
    private Integer guestCapacity;

    @Schema(example = "1")
    private Integer bedAmount;

    @Schema(example = "Cama Queen-size")
    private String bedType;

    @Schema(example = "Banheiro completo com ducha")
    private String bathroom;

    @Schema(example = "249.90")
    private BigDecimal price;

    private List<NewFurnitureDto> furniture;
    private BuildingDto building;
    private LocationSummaryDto location;

}
