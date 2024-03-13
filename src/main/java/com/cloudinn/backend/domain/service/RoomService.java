package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.domain.model.Furniture;
import com.cloudinn.backend.domain.model.Room;

public interface RoomService {

    Room create(Room room);
    Room update(Long id, Room room);
    Room get(Long id);
    void delete(Long id);
    void addFurniture(Long roomId, Furniture furniture);
    void removeFurniture(Long roomId, Furniture furniture);

}
