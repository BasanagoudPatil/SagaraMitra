package com.HonnaBot.SagaraMitra.Repositories;

import com.HonnaBot.SagaraMitra.Entity.PrivateBoatBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrivateBoatBookingRepository extends JpaRepository<PrivateBoatBooking, Integer> {
    List<PrivateBoatBooking> findByBoatIdAndBookingDate(int boatId, String bookingDate);
}
