package com.cloudinn.backend.api.model;

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
    private String street;

    @NotBlank
    private String number;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String zipcode;

}
