package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.domain.repository.ReservationRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationCleanupServiceImpl implements ReservationCleanupService {

    private final ReservationRepository reservationRepository;

    public ReservationCleanupServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    @Async
    @Scheduled(cron = "0 0 0 * * *")
    public void cleanExpiredReservations() {
        LocalDate oneWeekAgo = LocalDate.now().minusDays(7L);
        reservationRepository.deleteAllByCheckout(oneWeekAgo);
    }

}
