package com.cloudinn.backend.api.model.user;

import com.cloudinn.backend.api.model.AddressDto;
import com.cloudinn.backend.domain.data.OutputDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto implements OutputDto {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "João das Neves")
    private String name;

    @Schema(example = "1990-08-15")
    private LocalDate birthday;

    @Schema(example = "05511977775555")
    private String phone;

    @Schema(example = "email@email.com")
    private String email;

    @Schema(example = "24557686001")
    private String cpf;

    @Schema(example = "AA000001")
    private String passport;

    @Schema(example = "BR")
    private String country;

    private AddressDto address;

}
