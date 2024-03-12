package com.cloudinn.backend.domain.model;

import com.cloudinn.backend.api.model.NewUserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {

    @Id
    private String id;

    private String name;
    private LocalDate birthday;
    private String phone;
    private String email;
    private String cpf;
    private String passport;
    private String country;
    private Address address;
    private boolean enabled;

    public User(NewUserDto newUserDto) {
        this.name = newUserDto.getName();
        this.birthday = newUserDto.getBirthday();
        this.phone = newUserDto.getPhone();
        this.email = newUserDto.getEmail();
        this.cpf = newUserDto.getCpf();
        this.passport = newUserDto.getPassport();
        this.country = newUserDto.getCountry();
        this.address = new Address(newUserDto.getAddress());
        this.enabled = false;
    }

}
