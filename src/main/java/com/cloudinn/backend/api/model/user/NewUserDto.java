package com.cloudinn.backend.api.model.user;

import com.cloudinn.backend.api.model.AddressDto;
import com.cloudinn.backend.domain.model.validation.CountryCode;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
public class NewUserDto implements UserInputDto {

    @NotBlank
    private String name;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Schema(example = "1990-08-15")
    private LocalDate birthday;

    @NotBlank
    @Pattern(regexp = "\\d{14}")
    @Schema(example = "05511977775555")
    private String phone;

    @NotNull
    @Email
    @Schema(example = "email@email.com")
    private String email;

    @CPF
    @Schema(example = "24557686001")
    private String cpf;

    @Schema(example = "AA000001")
    private String passport;

    @CountryCode
    @Schema(example = "BR")
    private String country;

    @NotNull
    @Valid
    private AddressDto address;

}
