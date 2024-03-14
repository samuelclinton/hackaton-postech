package com.cloudinn.backend.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class AddedOptional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;

    @ManyToOne
    private Optional optional;

    public String getFormattedAddedOptionalName() {
        return String.format("%sx - %s", amount, optional.getDescription());
    }

    public BigDecimal getTotalPrice() {
        return this.optional.getPrice().multiply(BigDecimal.valueOf(this.amount));
    }

}
