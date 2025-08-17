package com.HonnaBot.SagaraMitra.Service;

import com.HonnaBot.SagaraMitra.Entity.*;
import com.HonnaBot.SagaraMitra.Repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvailabilityService {

    private final PublicBoatStatusRepository pubStatusRepo;
    private final PrivateBoatStatusRepository priStatusRepo;
    private final PublicBoatRepository publicBoatRepo;
    private final PublicBoatSlotRepository publicBoatSlotRepo;
    private final PrivateBoatRepository privateBoatRepo;
    private final PrivateBoatSlotRepository privateBoatSlotRepo;

    public boolean isPublicAvailable(int boatId, LocalDate date, int slotId, int seats) {
        Optional<PublicBoatStatus> statusOpt = pubStatusRepo.findByBoat_BoatIdAndBookingDateAndSlot_SlotId(boatId, date, slotId);

        PublicBoatStatus status;
        if (statusOpt.isEmpty()) {
            Optional<PublicBoat> boatOpt = publicBoatRepo.findById(boatId);
            Optional<PublicBoatSlot> slotOpt = publicBoatSlotRepo.findById(slotId);

            if (boatOpt.isEmpty() || slotOpt.isEmpty()) {
                return false; // If missing, invalid input
            }

            status = new PublicBoatStatus();
            status.setBoat(boatOpt.get());
            status.setSlot(slotOpt.get());
            status.setBookingDate(date);
            status.setAvailableSeats(boatOpt.get().getCapacity());
            status.setAvailable(true);
            status.setBoatStatus("Available");
            pubStatusRepo.save(status);
        } else {
            status = statusOpt.get();
        }

        return status.isAvailable() && status.getAvailableSeats() >= seats;
    }

    public boolean isPrivateAvailable(int boatId, LocalDate date, int slotId) {
        Optional<PrivateBoatStatus> statusOpt = priStatusRepo.findByBoat_BoatIdAndBookingDateAndSlot_SlotId(boatId, date, slotId);

        PrivateBoatStatus status;

        if (statusOpt.isEmpty()) {
            Optional<PrivateBoat> boatOpt = privateBoatRepo.findById(boatId);
            Optional<PrivateBoatSlot> slotOpt = privateBoatSlotRepo.findById(slotId);

            if (boatOpt.isEmpty() || slotOpt.isEmpty()) {
                return false; // If missing, invalid input
            }

            status = new PrivateBoatStatus();
            status.setBoat(boatOpt.get());
            status.setSlot(slotOpt.get());
            status.setBookingDate(date);
            status.setAvailable(true);
            status.setBookingStatus("Available");
            priStatusRepo.save(status);
        } else {
            status = statusOpt.get();
        }

        return status.isAvailable();
    }
}
