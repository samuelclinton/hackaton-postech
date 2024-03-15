package com.cloudinn.backend.api.model.room;

import com.cloudinn.backend.domain.data.InputDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class NewFurnitureDto implements InputDto {

    @NotNull
    @Positive
    @Schema(example = "2")
    private Integer amount;

    @NotBlank
    @Schema(example = "TV 50 QLED polegadas")
    private String description;

}
