package com.cloudinn.backend.api.model.user;

import com.cloudinn.backend.api.model.AddressDto;
import com.cloudinn.backend.domain.model.validation.CountryCode;
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
    private LocalDate birthday;

    @NotBlank
    @Pattern(regexp = "\\d{14}")
    private String phone;

    @NotNull
    @Email
    private String email;

    @CPF
    private String cpf;

    private String passport;

    @CountryCode
    private String country;

    @NotNull
    @Valid
    private AddressDto address;

}
