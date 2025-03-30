package com.HonnaBot.SagaraMitra.Repositories;

import com.HonnaBot.SagaraMitra.Entity.PublicBoatBooking;
import com.HonnaBot.SagaraMitra.Entity.PublicBoatSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PublicBoatBookingRepository extends JpaRepository<PublicBoatBooking, Integer> {

    @Query("SELECT ps FROM PublicBoatSlot ps WHERE ps.slotId NOT IN " +
            "(SELECT pb.slot.slotId FROM PublicBoatBooking pb WHERE pb.boat.boatId = :boatId AND pb.bookingDate = :bookingDate)")
    List<PublicBoatSlot> findAvailableSlots(@Param("boatId") int boatId, @Param("bookingDate") LocalDate bookingDate);
}
