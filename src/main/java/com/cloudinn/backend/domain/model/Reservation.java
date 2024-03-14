package com.cloudinn.backend.domain.model;

import com.cloudinn.backend.domain.data.DomainEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Reservation implements DomainEntity {

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
    private List<AddedOptional> addedOptionals;

    @ManyToOne
    private User user;

    public void calculateSubtotal() {
        BigDecimal totalRoomPrice = BigDecimal.ZERO;
        for (Room room : this.rooms) {
            totalRoomPrice = totalRoomPrice.add(room.getPrice());
        }
        BigDecimal totalAddedOptionalPrice = BigDecimal.ZERO;
        for (AddedOptional optional : this.addedOptionals) {
            totalAddedOptionalPrice = totalAddedOptionalPrice.add(optional.getTotalPrice());
        }
        this.subtotal = totalRoomPrice.add(totalAddedOptionalPrice);
    }

    public boolean roomCapacityCanSupportGuests() {
        Integer totalRoomCapacity = 0;
        for (Room room : this.rooms) {
            totalRoomCapacity += room.getGuestCapacity();
        }
        return totalRoomCapacity >= this.guests;
    }

}
