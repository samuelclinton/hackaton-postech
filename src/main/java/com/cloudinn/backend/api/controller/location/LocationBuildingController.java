package com.cloudinn.backend.api.controller.location;

import com.cloudinn.backend.api.model.NewBuildingDto;
import com.cloudinn.backend.api.model.location.LocationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Locations")
public interface LocationBuildingController {


    @Operation(
            summary = "Adiciona um prédio",
            description = "Adiciona um prédio"
    )
    LocationDto addBuilding(@Parameter(description = "O ID de uma localidade", in = ParameterIn.PATH, example = "1") Long locationId,
                            NewBuildingDto newBuildingDto);

    @Operation(
            summary = "Remove um prédio",
            description = "Remove um prédio"
    )
    LocationDto removeBuilding(@Parameter(description = "O ID de uma localidade", in = ParameterIn.PATH, example = "1") Long locationId,
                               @Parameter(description = "O ID de um prédio", in = ParameterIn.PATH, example = "1") Long buildingId);

}
