package com.HonnaBot.SagaraMitra.controller;

import com.HonnaBot.SagaraMitra.Entity.PublicBoat;
import com.HonnaBot.SagaraMitra.Entity.PublicBoatSlot;
import com.HonnaBot.SagaraMitra.Repositories.PublicBoatRepository;
import com.HonnaBot.SagaraMitra.Service.PublicBoatBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/public-boat-booking")
@RequiredArgsConstructor
public class PublicBoatBookingController {

    private final PublicBoatBookingService bookingService;
    private final PublicBoatRepository boatRepository;

    @GetMapping("/available-slots")
    public List<PublicBoatSlot> getAvailableSlots(@RequestParam int boatId, @RequestParam LocalDate bookingDate) {
        return bookingService.getAvailableSlots(boatId, bookingDate);
    }

    @PostMapping("/book")
    public String bookBoat(@RequestBody Map<String, Object> bookingData) {
        Long  userId = (Long ) bookingData.get("userId");
        int boatId = (int) bookingData.get("boatId");
        int slotId = (int) bookingData.get("slotId");
        LocalDate bookingDate = (LocalDate) bookingData.get("bookingDate");
        int seatsBooked = (int) bookingData.get("seatsBooked");

        return bookingService.bookPublicBoat(userId, boatId, slotId, bookingDate, seatsBooked);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PublicBoat>> getAllBoats() {
        List<PublicBoat> boats = boatRepository.findAll();
        return ResponseEntity.ok(boats);
    }
}
