package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.InputDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AddedOptionalDto implements InputDto {

    @NotNull
    @Positive
    @Schema(example = "2")
    private Integer amount;

    @NotNull
    @Valid
    private OptionalDto optional;

}
