package com.HonnaBot.SagaraMitra.controller;

import com.HonnaBot.SagaraMitra.Service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/availability")
@CrossOrigin("*")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    /** ✅ PUBLIC BOAT AVAILABILITY CHECK */
    @GetMapping("/public")
    public Map<String, Object> checkPublicBoat(@RequestParam int boatId,
                                               @RequestParam String date,
                                               @RequestParam int slotId,
                                               @RequestParam int seats) {
        Map<String, Object> response = new HashMap<>();

        LocalDate bookingDate = LocalDate.parse(date);
        if (bookingDate.isBefore(LocalDate.now())) {
            response.put("available", false);
            response.put("message", "Cannot book for past dates.");
            return response;
        }

        boolean ok = availabilityService.isPublicAvailable(boatId, bookingDate, slotId, seats);

        response.put("available", ok);
        response.put("message", ok ? "Slot available ✅" : "Not enough seats or unavailable.");
        return response;
    }

    /** ✅ PRIVATE BOAT AVAILABILITY CHECK */
    @GetMapping("/private")
    public Map<String, Object> checkPrivateBoat(@RequestParam int boatId,
                                                @RequestParam String date,
                                                @RequestParam int slotId) {
        Map<String, Object> response = new HashMap<>();

        LocalDate bookingDate = LocalDate.parse(date);
        if (bookingDate.isBefore(LocalDate.now())) {
            response.put("available", false);
            response.put("message", "Cannot book for past dates.");
            return response;
        }

        boolean ok = availabilityService.isPrivateAvailable(boatId, bookingDate, slotId);

        response.put("available", ok);
        response.put("message", ok ? "Slot available ✅" : "Not available or already booked.");
        return response;
    }
}
