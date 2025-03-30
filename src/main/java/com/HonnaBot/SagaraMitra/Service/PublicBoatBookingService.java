package com.HonnaBot.SagaraMitra.Service;

import com.HonnaBot.SagaraMitra.Entity.PublicBoat;
import com.HonnaBot.SagaraMitra.Entity.PublicBoatBooking;
import com.HonnaBot.SagaraMitra.Entity.PublicBoatSlot;
import com.HonnaBot.SagaraMitra.Entity.User;
import com.HonnaBot.SagaraMitra.Repositories.PublicBoatBookingRepository;
import com.HonnaBot.SagaraMitra.Repositories.PublicBoatRepository;
import com.HonnaBot.SagaraMitra.Repositories.PublicBoatSlotRepository;
import com.HonnaBot.SagaraMitra.Repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PublicBoatBookingService {
    @Autowired
    private PublicBoatRepository publicBoatRepository;
    private final PublicBoatBookingRepository bookingRepository;
    private final PublicBoatSlotRepository slotRepository;
    private final UserRepository userRepository;

    public List<PublicBoatSlot> getAvailableSlots(int boatId, LocalDate bookingDate) {
        return bookingRepository.findAvailableSlots(boatId, bookingDate);
    }

    public String bookPublicBoat(Long userId, int boatId, int slotId, LocalDate bookingDate, int seatsBooked) {
        if (!userRepository.existsById(userId)) {
            return "User not found!";
        }

        Optional<PublicBoat> boatOptional = publicBoatRepository.findById(boatId);
        if (!boatOptional.isPresent()) {
            return "Boat not found!";
        }
        Optional<PublicBoatSlot> slotOptional = slotRepository.findById(slotId);
        if (!slotOptional.isPresent()) {
            return "Slot not found!";
        }
        List<PublicBoatSlot> availableSlots = getAvailableSlots(boatId, bookingDate);
        boolean slotAvailable = availableSlots.stream().anyMatch(slot -> slot.getSlotId() == slotId);

        if (!slotAvailable) {
            return "Slot not available!";
        }

        PublicBoatBooking booking = new PublicBoatBooking();
        booking.setUser(userRepository.findById(userId).get());
        booking.setBoat(boatOptional.get());
        booking.setSlot(slotRepository.findById(slotId).get());
        booking.setBookingDate(bookingDate);
        booking.setSeatsBooked(seatsBooked);

        bookingRepository.save(booking);
        return "Booking successful!";
    }
}
