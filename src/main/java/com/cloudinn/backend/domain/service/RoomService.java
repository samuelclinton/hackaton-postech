package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.domain.model.Furniture;
import com.cloudinn.backend.domain.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {

    Room create(Room newRoom);
    Room update(Long id, Room updatedRoom);
    Room get(Long id);
    List<Room> listAvailable(LocalDate checkin, LocalDate checkout, Integer guests);
    void delete(Long id);
    void addFurniture(Long roomId, Furniture furniture);
    void removeFurniture(Long roomId, Furniture furniture);

}
