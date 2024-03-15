package com.cloudinn.backend.api.controller;

import com.cloudinn.backend.api.model.room.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Rooms")
public interface RoomController {

    @Operation(
            summary = "Cria um quarto",
            description = "Cria um quarto"
    )
    RoomDto create(NewRoomDto newRoomDto);

    @Operation(
            summary = "Edita um quarto",
            description = "Edita um quarto"
    )
    RoomDto update(@Parameter(description = "O ID de um quarto", in = ParameterIn.PATH, example = "1") Long roomId,
                   UpdateRoomDto updateRoomDto);

    @Operation(
            summary = "Busca um quarto",
            description = "Busca um quarto"
    )
    RoomDto get(@Parameter(description = "O ID de um quarto", in = ParameterIn.PATH, example = "1") Long roomId);

    @Operation(
            summary = "Lista os quartos disponíveis",
            description = "Lista os quartos disponíveis de acordo com so parâmeros fornecidos pelo usuário"
    )
    List<RoomSummaryDto> listAvailable(
            @Parameter(description = "Data de checkin", in = ParameterIn.QUERY, example = "2024-03-14") String checkin,
            @Parameter(description = "Data de checkout", in = ParameterIn.QUERY, example = "2024-03-15") String checkout,
            @Parameter(description = "Quantidade de hóspedes", in = ParameterIn.QUERY, example = "4") Integer guests);

    @Operation(
            summary = "Exclui um quarto",
            description = "Exclui um quarto"
    )
    void delete(@Parameter(description = "O ID de um quarto", in = ParameterIn.PATH, example = "1") Long id);

    @Operation(
            summary = "Adiciona um móvel",
            description = "Adiciona um móvel"
    )
    RoomDto addFurniture(@Parameter(description = "O ID de um quarto", in = ParameterIn.PATH, example = "1") Long roomId,
                         NewFurnitureDto newFurnitureDto);

    @Operation(
            summary = "Remove um móvel",
            description = "Remove um móvel"
    )
    RoomDto removeFurniture(@Parameter(description = "O ID de um quarto", in = ParameterIn.PATH, example = "1") Long roomId,
                            @Parameter(description = "O ID de um móvel", in = ParameterIn.PATH, example = "1") Long furnitureId);

}
