package com.cloudinn.backend.api.model;

import com.cloudinn.backend.domain.data.InputDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IdRepresentationDto implements InputDto {

    @NotNull
    private Long id;

}
