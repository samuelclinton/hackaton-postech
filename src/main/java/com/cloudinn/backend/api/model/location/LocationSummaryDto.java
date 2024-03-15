package com.cloudinn.backend.api.model.location;

import com.cloudinn.backend.api.model.AddressDto;
import com.cloudinn.backend.domain.data.OutputDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LocationSummaryDto implements OutputDto {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "Hotel Zimbábue")
    private String name;

    private AddressDto address;

}
