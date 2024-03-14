package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.InputDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AddedOptionalDto implements InputDto {

    @NotNull
    @Positive
    private Integer amount;

    @NotNull
    @Valid
    private OptionalDto optional;

}
