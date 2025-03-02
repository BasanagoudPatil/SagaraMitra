package com.HonnaBot.SagaraMitra.Repositories;

import com.HonnaBot.SagaraMitra.Entity.PrivateBoatStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrivateBoatStatusRepository extends JpaRepository<PrivateBoatStatus, Integer> {
    Optional<PrivateBoatStatus> findByBoatIdAndBookingDateAndSlotId(int boatId, String bookingDate, int slotId);
}