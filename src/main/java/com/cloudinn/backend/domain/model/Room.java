package com.cloudinn.backend.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private RoomType type;
    private Integer guestCapacity;
    private Integer bedAmount;
    private String bedType;
    private String bathroom;
    private BigDecimal price;

    @OneToMany
    private final List<Furniture> furniture = new ArrayList<>();

    @ManyToOne
    private Building building;

    @ManyToOne
    private Location location;

}
