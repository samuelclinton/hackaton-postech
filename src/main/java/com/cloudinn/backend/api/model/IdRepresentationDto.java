package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.InputDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IdRepresentationDto implements InputDto {

    @NotNull
    @Schema(example = "1")
    private Long id;

}
