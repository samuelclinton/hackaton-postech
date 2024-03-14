package com.cloudinn.backend.domain.repository;

import com.cloudinn.backend.domain.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    void deleteAllByCheckout(LocalDate checkout);

}
