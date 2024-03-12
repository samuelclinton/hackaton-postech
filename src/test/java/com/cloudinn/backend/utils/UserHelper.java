package com.cloudinn.backend.utils;

import com.cloudinn.backend.api.model.AddressDto;
import com.cloudinn.backend.api.model.NewUserDto;

import java.time.LocalDate;

public class UserHelper {

    public static final String USER_ID = "4439ce91-36a5-4de6-8eb3-d7db5f7d7cf6";

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

}
