package com.cloudinn.backend.api.model.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
public class UpdateUserDto implements UserInputDto {

    @Schema(example = "João das Neves")
    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Schema(example = "1990-08-15")
    private LocalDate birthday;

    @Pattern(regexp = "\\d{14}")
    @Schema(example = "05511977775555")
    private String phone;

    @Email
    @Schema(example = "email@email.com")
    private String email;

}
