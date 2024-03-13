package com.cloudinn.backend.api.controller;

import com.cloudinn.backend.api.model.room.*;

import java.util.List;

public interface RoomController {

    RoomDto create(NewRoomDto newRoomDto);
    RoomDto update(Long roomId, UpdateRoomDto updateRoomDto);
    RoomDto get(Long roomId);

    List<RoomSummaryDto> listAvailable(String checkin, String checkout, Integer guests);
    void delete(Long id);
    RoomDto addFurniture(Long roomId, NewFurnitureDto newFurnitureDto);
    RoomDto removeFurniture(Long roomId, Long furnitureId);

}
