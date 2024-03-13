package com.cloudinn.backend.utils;

import com.cloudinn.backend.api.model.AddressDto;
import com.cloudinn.backend.api.model.NewAmenityDto;
import com.cloudinn.backend.api.model.location.NewLocationDto;

public class LocalityHelper {

    public static NewLocationDto generateNewLocalityDto() {
        return NewLocationDto.builder()
                .name("Hotel")
                .address(
                        AddressDto.builder()
                                .street("Street name")
                                .number("100")
                                .city("City")
                                .state("State")
                                .zipcode("01234567")
                                .build()
                )

//                .optionals(List.of(
//                        OptionalDto.builder()
//                                .type(OptionalType.SERVICE)
//                                .description("Massagem")
//                                .price(BigDecimal.valueOf(89.9))
//                                .build()
//                ))
//                .buildings(List.of(
//                        BuildingDto.builder()
//                                .description("Prédio principal")
//                                .build()
//                ))
                .build();
    }

    public static NewAmenityDto generateAmenityDto() {
        return NewAmenityDto.builder()
                .amount(1)
                .description("Piscina olímpica")
                .build();
    }

}
