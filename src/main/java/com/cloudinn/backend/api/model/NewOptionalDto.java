package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.InputDto;
import com.cloudinn.backend.domain.model.OptionalType;
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
    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

}
