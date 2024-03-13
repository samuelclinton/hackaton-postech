package com.cloudinn.backend.domain.repository;

import com.cloudinn.backend.domain.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room r WHERE r.available = true AND r.id NOT IN " +
            "(SELECT room.id FROM Reservation res JOIN res.rooms room " +
            "WHERE (:checkin BETWEEN res.checkin AND res.checkout) OR " +
            "(:checkout BETWEEN res.checkin AND res.checkout) OR " +
            "(:checkin < res.checkin AND :checkout > res.checkout))")
    List<Room> findAvailableRooms(LocalDate checkin, LocalDate checkout);

}
