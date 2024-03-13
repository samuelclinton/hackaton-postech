package com.cloudinn.backend.api.model.room;

import com.cloudinn.backend.domain.data.InputDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class NewFurnitureDto implements InputDto {

    @NotNull
    @Positive
    private Integer amount;

    @NotBlank
    private String description;

}
