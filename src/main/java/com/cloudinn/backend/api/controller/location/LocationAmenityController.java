package com.cloudinn.backend.api.controller.location;

import com.cloudinn.backend.api.model.NewAmenityDto;
import com.cloudinn.backend.api.model.location.LocationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Locations")
public interface LocationAmenityController {

    @Operation(
            summary = "Adiciona uma amenidade",
            description = "Adiciona uma amenidade"
    )
    LocationDto addAmenity(@Parameter(description = "O ID de uma localidade", in = ParameterIn.PATH, example = "1") Long locationId,
                           NewAmenityDto newAmenityDto);

    @Operation(
            summary = "Remove uma amenidade",
            description = "Remove uma amenidade"
    )
    LocationDto removeAmenity(@Parameter(description = "O ID de uma localidade", in = ParameterIn.PATH, example = "1") Long locationId,
                              @Parameter(description = "O ID de uma amenidade", in = ParameterIn.PATH, example = "1") Long amenityId);

}
