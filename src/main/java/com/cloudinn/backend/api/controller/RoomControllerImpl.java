package com.cloudinn.backend.api.controller;

import com.cloudinn.backend.api.model.*;
import com.cloudinn.backend.domain.data.DomainEntityMapperImpl;
import com.cloudinn.backend.domain.model.Furniture;
import com.cloudinn.backend.domain.model.Room;
import com.cloudinn.backend.domain.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomControllerImpl implements RoomController {

    private final RoomService roomService;
    private final DomainEntityMapperImpl<RoomInputDto, RoomDto, Room> roomMapper;
    private final DomainEntityMapperImpl<NewFurnitureDto, FurnitureDto, Furniture> furnitureMapper;

    public RoomControllerImpl(RoomService roomService,
                              DomainEntityMapperImpl<RoomInputDto, RoomDto, Room> roomMapper,
                              DomainEntityMapperImpl<NewFurnitureDto, FurnitureDto, Furniture> furnitureMapper) {
        this.roomService = roomService;
        this.roomMapper = roomMapper;
        this.furnitureMapper = furnitureMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public RoomDto create(@RequestBody @Valid NewRoomDto newRoomDto) {
        Room createdRoom = roomService.create(roomMapper.mapInputToEntity(newRoomDto, Room.class));
        return roomMapper.mapEntityToOutput(createdRoom, RoomDto.class);
    }

    @Override
    @PutMapping("/{roomId}")
    @Transactional
    public RoomDto update(@PathVariable Long roomId, @RequestBody @Valid UpdateRoomDto updateRoomDto) {
        Room updatedRoom = roomMapper.mapInputToEntity(updateRoomDto, Room.class);
        return roomMapper.mapEntityToOutput(roomService.update(roomId, updatedRoom), RoomDto.class);
    }

    @Override
    @GetMapping("/{roomId}")
    @Transactional
    public RoomDto get(@PathVariable Long roomId) {
        return roomMapper.mapEntityToOutput(roomService.get(roomId), RoomDto.class);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void delete(@PathVariable Long id) {
        roomService.delete(id);
    }

    @Override
    @PostMapping("/{roomId}/furniture")
    @Transactional
    public RoomDto addFurniture(@PathVariable Long roomId, @RequestBody @Valid NewFurnitureDto newFurnitureDto) {
        roomService.addFurniture(roomId, furnitureMapper.mapInputToEntity(newFurnitureDto, Furniture.class));
        return roomMapper.mapEntityToOutput(roomService.get(roomId), RoomDto.class);
    }

    @Override
    @DeleteMapping("/{roomId}/furniture/{furnitureId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public RoomDto removeFurniture(@PathVariable Long roomId, @PathVariable Long furnitureId) {
        Furniture furnitureToBeRemoved = new Furniture();
        furnitureToBeRemoved.setId(furnitureId);
        roomService.removeFurniture(roomId, furnitureToBeRemoved);
        return roomMapper.mapEntityToOutput(roomService.get(roomId), RoomDto.class);
    }

}
