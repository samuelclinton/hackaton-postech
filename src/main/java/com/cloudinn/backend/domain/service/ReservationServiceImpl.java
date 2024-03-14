package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.domain.exception.AddedOptionalNotFoundException;
import com.cloudinn.backend.domain.exception.NotEnoughGuestCapacityException;
import com.cloudinn.backend.domain.exception.ReservationNotFoundException;
import com.cloudinn.backend.domain.model.AddedOptional;
import com.cloudinn.backend.domain.model.Reservation;
import com.cloudinn.backend.domain.model.ReservationStatus;
import com.cloudinn.backend.domain.model.Room;
import com.cloudinn.backend.domain.repository.AddedOptionalRepository;
import com.cloudinn.backend.domain.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomService roomService;
    private final LocationService locationService;
    private final AddedOptionalRepository addedOptionalRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  RoomService roomService, LocationService locationService,
                                  AddedOptionalRepository addedOptionalRepository) {
        this.reservationRepository = reservationRepository;
        this.roomService = roomService;
        this.locationService = locationService;
        this.addedOptionalRepository = addedOptionalRepository;
    }

    @Override
    public AddedOptional getAddedOptional(Long id) {
        return addedOptionalRepository.findById(id)
                .orElseThrow(() -> new AddedOptionalNotFoundException("Nenhum serviço ou produto opcional encontrado" +
                        " com o id " + id));
    }

    @Override
    @Transactional
    public Reservation create(Reservation reservation) {
        getUpdatedPropertiesFromDatabase(reservation);
        if (reservation.roomCapacityCanSupportGuests()) {
            reservation.calculateSubtotal();
            return reservationRepository.save(reservation);
        } else {
            throw new NotEnoughGuestCapacityException("Os quartos selecionados suportam menos hóspedes" +
                    " do que o reservado");
        }
    }

    private void getUpdatedPropertiesFromDatabase(Reservation reservation) {
        List<Room> roomEntities = new ArrayList<>();
        reservation.getRooms().forEach(room -> roomEntities.add(roomService.get(room.getId())));
        reservation.setRooms(roomEntities);

        List<AddedOptional> addedOptionalEntities = new ArrayList<>();

        reservation.getAddedOptionals().forEach(addedOptional -> {
            var optional = locationService.getOptional(addedOptional.getOptional().getId());
            addedOptional.setOptional(optional);
            addedOptionalEntities.add(addedOptionalRepository.save(addedOptional));
        });
        reservation.setAddedOptionals(addedOptionalEntities);
    }

    @Override
    @Transactional
    public Reservation confirm(Long id) {
        Reservation reservation = get(id);
        reservation.setStatus(ReservationStatus.CONFIRMED);
        return reservationRepository.save(reservation);
    }

    @Override
    @Transactional
    public void cancel(Long id) {
        Reservation reservation = get(id);
        reservationRepository.delete(reservation);
    }

    @Override
    public Reservation get(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Nenhuma reserva encontrada com o id " + id));
    }

}
