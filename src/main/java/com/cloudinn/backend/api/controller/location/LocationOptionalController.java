package com.cloudinn.backend.api.controller.location;

import com.cloudinn.backend.api.model.NewOptionalDto;
import com.cloudinn.backend.api.model.location.LocationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Locations")
public interface LocationOptionalController {

    @Operation(
            summary = "Adiciona um opcional",
            description = "Adiciona um opcional"
    )
    LocationDto addOptional(@Parameter(description = "O ID de uma localidade", in = ParameterIn.PATH, example = "1") Long locationId,
                            NewOptionalDto newOptionalDto);

    @Operation(
            summary = "Remove um opcional",
            description = "Remove um opcional"
    )
    LocationDto removeOptional(@Parameter(description = "O ID de uma localidade", in = ParameterIn.PATH, example = "1") Long locationId,
                               @Parameter(description = "O ID de um opcional", in = ParameterIn.PATH, example = "1")  Long optionalId);

}
