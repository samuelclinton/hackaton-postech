package com.cloudinn.backend.api.controller;

import com.cloudinn.backend.api.model.user.NewUserDto;
import com.cloudinn.backend.api.model.user.UpdateUserDto;
import com.cloudinn.backend.api.model.user.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Users")
public interface UserController {

    @Operation(
            summary = "Cria um usuário",
            description = "Cria um usuário"
    )
    UserDto create(NewUserDto newUserDto);


    @Operation(
            summary = "Edita um usuário",
            description = "Edita um usuário"
    )
    UserDto update(@Parameter(description = "O ID de um usuário", in = ParameterIn.PATH, example = "1") Long id,
                   UpdateUserDto updateUserDto);

    @Operation(
            summary = "Busca um usuário",
            description = "Busca um usuário através do ID recebido por parâmetro de URL"
    )
    UserDto get(@Parameter(description = "O ID de um usuário", in = ParameterIn.PATH, example = "1") Long id);

    @Operation(
            summary = "Exclui um usuário",
            description = "Exclui um usuário"
    )
    void delete(@Parameter(description = "O ID de um usuário", in = ParameterIn.PATH, example = "1") Long id);

}
