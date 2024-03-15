package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.InputDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewAmenityDto implements InputDto {

    @Schema(example = "2")
    private Integer amount;

    @Schema(example = "Piscina olímpica")
    private String description;

}
