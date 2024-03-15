package com.cloudinn.backend.api.model.location;

import com.cloudinn.backend.api.model.AddressDto;
import com.cloudinn.backend.domain.data.InputDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewLocationDto implements InputDto {

    @NotBlank
    @Schema(example = "Hotel Zimbábue")
    private String name;

    @NotNull
    @Valid
    private AddressDto address;

}
