package com.cloudinn.backend.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@Entity
public class Role implements GrantedAuthority {

    @Id
    private Long id;

    private Authority authority;

    @Override
    public String getAuthority() {
        return this.authority.name();
    }

}
