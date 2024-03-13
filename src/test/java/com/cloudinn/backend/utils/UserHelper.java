package com.cloudinn.backend.utils;

import com.cloudinn.backend.api.model.AddressDto;
import com.cloudinn.backend.api.model.user.NewUserDto;
import com.cloudinn.backend.api.model.user.UpdateUserDto;

import java.time.LocalDate;

public class UserHelper {

    public static NewUserDto generateNewUserDto() {
        return NewUserDto.builder()
                .name("User")
                .birthday(LocalDate.of(2000, 12, 1))
                .phone("5511988887777")
                .email("user@email.com")
                .cpf("07594261046")
                .country("BR")
                .address(
                        AddressDto.builder()
                                .street("Street name")
                                .number("100")
                                .city("City")
                                .state("State")
                                .zipcode("01234567")
                                .build()
                )
                .build();
    }

    public static UpdateUserDto generateUpdateUserDto() {
        return UpdateUserDto.builder()
                .name("Updated Name")
                .birthday(LocalDate.of(1999, 12, 1))
                .phone("5511955556666")
                .email("new_email@email.com")
                .address(
                        AddressDto.builder()
                                .street("New Street name")
                                .number("1001")
                                .city("New City")
                                .state("New State")
                                .zipcode("07654321")
                                .build()
                )
                .build();
    }

}
