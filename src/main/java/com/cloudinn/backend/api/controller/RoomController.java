package com.cloudinn.backend.api.controller;

import com.cloudinn.backend.api.model.NewFurnitureDto;
import com.cloudinn.backend.api.model.NewRoomDto;
import com.cloudinn.backend.api.model.RoomDto;
import com.cloudinn.backend.api.model.UpdateRoomDto;

import java.util.List;

public interface RoomController {

    RoomDto create(NewRoomDto newRoomDto);
    RoomDto update(Long roomId, UpdateRoomDto updateRoomDto);
    RoomDto get(Long roomId);

    List<RoomDto> listAvailable(String checkin, String checkout);
    void delete(Long id);
    RoomDto addFurniture(Long roomId, NewFurnitureDto newFurnitureDto);
    RoomDto removeFurniture(Long roomId, Long furnitureId);

}
