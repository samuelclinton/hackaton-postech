package com.cloudinn.backend.api.model.user;

import com.cloudinn.backend.api.model.AddressDto;
import com.cloudinn.backend.domain.data.OutputDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto implements OutputDto {

    private Long id;
    private String name;
    private LocalDate birthday;
    private String phone;
    private String email;
    private String cpf;
    private String passport;
    private String country;
    private AddressDto address;

}
