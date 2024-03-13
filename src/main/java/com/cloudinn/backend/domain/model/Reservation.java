package com.cloudinn.backend.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ReservationStatus status = ReservationStatus.CREATED;
    private Integer guests;
    private LocalDate checkin;
    private LocalDate checkout;
    private BigDecimal subtotal;

    @OneToMany
    private List<Room> rooms;

    @OneToMany
    private List<Optional> optionals;

    @ManyToOne
    private User user;

    public void calculateSubtotal() {
        BigDecimal totalRoomPrice = BigDecimal.ZERO;
        for (Room room : this.rooms) {
            totalRoomPrice = totalRoomPrice.add(room.getPrice());
        }
        BigDecimal totalOptionalPrice = BigDecimal.ZERO;
        for (Optional optional : this.optionals) {
            totalOptionalPrice = totalOptionalPrice.add(optional.getPrice());
        }
        this.subtotal = totalRoomPrice.add(totalOptionalPrice);
    }

}
