package com.cloudinn.backend.domain.model;

import com.cloudinn.backend.api.model.AddressDto;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Address {

    private String street;
    private String number;
    private String city;
    private String state;
    private String zipcode;

    public Address(AddressDto addressDto) {
        this.street = addressDto.getStreet();
        this.number = addressDto.getNumber();
        this.city = addressDto.getCity();
        this.state = addressDto.getState();
        this.zipcode = addressDto.getZipcode();
    }

}
