package com.cloudinn.backend.api.model.room;

import com.cloudinn.backend.domain.data.OutputDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FurnitureDto implements OutputDto {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "2")
    private Integer amount;

    @Schema(example = "TV 50 QLED polegadas")
    private String description;

}
