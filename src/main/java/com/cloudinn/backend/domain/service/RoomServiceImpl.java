package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.api.model.room.NewRoomDto;
import com.cloudinn.backend.api.model.room.RoomDto;
import com.cloudinn.backend.domain.data.DomainEntityMapperImpl;
import com.cloudinn.backend.domain.exception.NotEnoughGuestCapacityException;
import com.cloudinn.backend.domain.exception.RoomNotFoundException;
import com.cloudinn.backend.domain.model.Furniture;
import com.cloudinn.backend.domain.model.Room;
import com.cloudinn.backend.domain.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final DomainEntityMapperImpl<NewRoomDto, RoomDto, Room> roomMapper;

    public RoomServiceImpl(RoomRepository roomRepository,
                           DomainEntityMapperImpl<NewRoomDto, RoomDto, Room> roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    @Override
    @Transactional
    public Room create(Room newRoom) {
        return roomRepository.saveAndFlush(newRoom);
    }

    @Override
    @Transactional
    public Room update(Long id, Room updatedRoom) {
        Room existingRoom = get(id);
        roomMapper.copyPropertiesBetweenEntities(updatedRoom, existingRoom);
        return roomRepository.saveAndFlush(existingRoom);
    }

    @Override
    public Room get(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException("Nenhum quarto encontrado com o id " + id));
    }

    @Override
    public List<Room> listAvailable(LocalDate checkin, LocalDate checkout, Integer guests) {
        var rooms = roomRepository.findAvailableRooms(checkin, checkout);
        if (guestCapacitySupportsGuestAmount(rooms, guests)) {
            return rooms;
        } else {
            throw new NotEnoughGuestCapacityException("Não há quartos disponíveis suficientes para essa" +
                    " quantidade de hóspedes");
        }
    }

    private boolean guestCapacitySupportsGuestAmount(List<Room> rooms, Integer guestAmount) {
        Integer totalRoomCapacity = 0;
        for (Room room : rooms) {
            totalRoomCapacity += room.getGuestCapacity();
        }
        return totalRoomCapacity >= guestAmount;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        roomRepository.delete(get(id));
    }

    @Override
    @Transactional
    public void addFurniture(Long roomId, Furniture furniture) {
        Room existingRoom = get(roomId);
        existingRoom.addFurniture(furniture);
        roomRepository.saveAndFlush(existingRoom);
    }

    @Override
    @Transactional
    public void removeFurniture(Long roomId, Furniture furniture) {
        Room existingRoom = get(roomId);
        existingRoom.removeFurniture(furniture);
        roomRepository.saveAndFlush(existingRoom);
    }

}
