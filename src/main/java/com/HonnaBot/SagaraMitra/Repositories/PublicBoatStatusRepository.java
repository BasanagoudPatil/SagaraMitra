package com.HonnaBot.SagaraMitra.Repositories;

import com.HonnaBot.SagaraMitra.Entity.PublicBoatStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublicBoatStatusRepository extends JpaRepository<PublicBoatStatus, Integer> {
    Optional<PublicBoatStatus> findByBoatIdAndBookingDateAndSlotId(int boatId, String bookingDate, int slotId);
}
