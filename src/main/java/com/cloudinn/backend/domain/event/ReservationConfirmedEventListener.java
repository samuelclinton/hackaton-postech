package com.cloudinn.backend.domain.event;

import com.cloudinn.backend.domain.service.NotificationService;
import com.cloudinn.backend.domain.service.NotificationService.Notification;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

@Component
public class ReservationConfirmedEventListener {

    private final NotificationService notificationService;

    public ReservationConfirmedEventListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @EventListener
    public void handleReservationConfirmedEvent(ReservationConfirmedEvent event) {
        var reservation = event.reservation();
        var location = reservation.getRooms().get(0).getLocation();
        var rooms = new ArrayList<RoomEventModel>();
        var addedOptionals = new ArrayList<AddedOptionalEventModel>();

        reservation.getRooms().forEach(room
                -> rooms.add(new RoomEventModel(room.getFormattedRoomName(), room.getPrice())));
        reservation.getAddedOptionals().forEach(addedOptional
                -> addedOptionals.add(new AddedOptionalEventModel(addedOptional.getFormattedAddedOptionalName(),
                addedOptional.getTotalPrice())));

        var variables = new HashMap<String, Object>();

        variables.put("user", reservation.getUser().getName());
        variables.put("guests", reservation.getGuests());
        variables.put("hotel", location.getName());
        variables.put("address", location.getAddress().getFormattedAddress());
        variables.put("checkin", formatarData(reservation.getCheckin()));
        variables.put("checkout", formatarData(reservation.getCheckout()));
        variables.put("rooms", rooms);
        variables.put("totalRoomPrice", reservation.calculateTotalRoomPrice());
        variables.put("addedOptionals", addedOptionals);
        variables.put("totalAddedOptionalsPrice", reservation.calculateTotalAddedOptionalsPrice());
        variables.put("totalPrice", reservation.getSubtotal());

        var notification = Notification.builder()
                .receiver(reservation.getUser().getEmail())
                .subject("Reserva confirmada")
                .body("reservationconfirmed.html")
                .variables(variables)
                .build();

        notificationService.send(notification);
    }

    private String formatarData(LocalDate localDate) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateFormatter.format(localDate);
    }

}
