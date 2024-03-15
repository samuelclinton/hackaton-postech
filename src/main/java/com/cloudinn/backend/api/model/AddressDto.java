package com.cloudinn.backend.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    @NotBlank
    @Schema(example = "Avenida Carvalho")
    private String street;

    @NotBlank
    @Schema(example = "102")
    private String number;

    @NotBlank
    @Schema(example = "Jabuticabal")
    private String city;

    @NotBlank
    @Schema(example = "São Paulo")
    private String state;

    @NotBlank
    @Schema(example = "01234567")
    private String zipcode;

}
