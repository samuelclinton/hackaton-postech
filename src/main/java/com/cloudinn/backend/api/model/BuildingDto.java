package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.OutputDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BuildingDto implements OutputDto {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "Prédio principal")
    private String description;

}
