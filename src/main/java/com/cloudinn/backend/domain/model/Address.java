package com.cloudinn.backend.domain.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {

    private String street;
    private String number;
    private String city;
    private String state;
    private String zipcode;

}
