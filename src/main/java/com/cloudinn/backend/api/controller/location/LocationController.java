package com.cloudinn.backend.api.controller.location;

import com.cloudinn.backend.api.model.location.LocationDto;
import com.cloudinn.backend.api.model.location.NewLocationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Locations")
public interface LocationController {

    @Operation(
            summary = "Cria uma localidade",
            description = "Cria uma localidade"
    )
    LocationDto create(NewLocationDto newLocationDto);

    @Operation(
            summary = "Edita uma localidade",
            description = "Edita uma localidade"
    )
    LocationDto update(@Parameter(description = "O ID de uma localidade", in = ParameterIn.PATH, example = "1") Long id,
                       NewLocationDto updateLocationDto);

    @Operation(
            summary = "Busca uma localidade",
            description = "Busca uma localidade"
    )
    LocationDto get(@Parameter(description = "O ID de uma localidade", in = ParameterIn.PATH, example = "1") Long id);

    @Operation(
            summary = "Exclui uma localidade",
            description = "Exclui uma localidade"
    )
    void delete(@Parameter(description = "O ID de uma localidade", in = ParameterIn.PATH, example = "1") Long id);

}
