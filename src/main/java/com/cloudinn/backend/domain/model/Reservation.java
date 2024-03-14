package com.cloudinn.backend.domain.model;

import com.cloudinn.backend.domain.data.DomainEntity;
import com.cloudinn.backend.domain.event.ReservationConfirmedEvent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Reservation extends AbstractAggregateRoot<Reservation> implements DomainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status = ReservationStatus.CREATED;

    @CreationTimestamp
    private LocalDateTime creationDate;

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

    public void confirm() {
        setStatus(ReservationStatus.CONFIRMED);
        registerEvent(new ReservationConfirmedEvent(this));
    }

    public BigDecimal calculateTotalRoomPrice() {
        BigDecimal totalRoomPrice = BigDecimal.ZERO;
        for (Room room : this.rooms) {
            totalRoomPrice = totalRoomPrice.add(room.getPrice());
        }
        return totalRoomPrice;
    }

    public BigDecimal calculateTotalAddedOptionalsPrice() {
        BigDecimal totalAddedOptionalPrice = BigDecimal.ZERO;
        for (AddedOptional optional : this.addedOptionals) {
            totalAddedOptionalPrice = totalAddedOptionalPrice.add(optional.getTotalPrice());
        }
        return totalAddedOptionalPrice;
    }

    public void calculateSubtotal() {
        this.subtotal = calculateTotalRoomPrice().add(calculateTotalAddedOptionalsPrice());
    }

    public boolean roomCapacityCanSupportGuests() {
        Integer totalRoomCapacity = 0;
        for (Room room : this.rooms) {
            totalRoomCapacity += room.getGuestCapacity();
        }
        return totalRoomCapacity >= this.guests;
    }

}
