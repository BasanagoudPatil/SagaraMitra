package com.HonnaBot.SagaraMitra.Repositories;

import com.HonnaBot.SagaraMitra.Entity.PublicBoatBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicBoatBookingRepository extends JpaRepository<PublicBoatBooking, Integer> {
    List<PublicBoatBooking> findByBoatIdAndBookingDate(int boatId, String bookingDate);
}
