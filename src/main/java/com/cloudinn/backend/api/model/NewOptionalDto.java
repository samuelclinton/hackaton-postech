package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.InputDto;
import com.cloudinn.backend.domain.model.OptionalType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class NewOptionalDto implements InputDto {

    @NotNull
    private OptionalType type;

    @NotBlank
    @Schema(example = "Cesta de café da manhã")
    private String description;

    @NotNull
    @Positive
    @Schema(example = "49.90")
    private BigDecimal price;

}
