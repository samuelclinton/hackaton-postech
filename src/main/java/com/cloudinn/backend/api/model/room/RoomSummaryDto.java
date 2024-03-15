package com.cloudinn.backend.api.model.room;

import com.cloudinn.backend.api.model.location.LocationSummaryDto;
import com.cloudinn.backend.domain.data.OutputDto;
import com.cloudinn.backend.domain.model.RoomType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomSummaryDto implements OutputDto {

    @Schema(example = "1")
    private Long id;

    private RoomType type;

    @Schema(example = "2")
    private Integer guestCapacity;

    @Schema(example = "1")
    private Integer bedAmount;

    @Schema(example = "Cama Queen-size")
    private String bedType;

    @Schema(example = "249.90")
    private BigDecimal price;

    private LocationSummaryDto location;

}
