package com.HonnaBot.SagaraMitra.controller;

import com.HonnaBot.SagaraMitra.Service.AvailabilityService;
import com.HonnaBot.SagaraMitra.Service.PublicBoatBookingService;
import com.HonnaBot.SagaraMitra.Service.PrivateBoatBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin("*")
public class BookingController {

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private PublicBoatBookingService publicService;

    @Autowired
    private PrivateBoatBookingService privateService;

    /** ✅ Public Boat Booking */
    @PostMapping("/public/confirm")
    public ResponseEntity<?> confirmPublicBooking(@RequestBody Map<String, Object> payload) {
        Map<String, Object> response = new HashMap<>();

        try {
            System.out.println("📥 Public Booking Payload: " + payload);

            long userId = Long.parseLong(payload.get("userId").toString());
            int boatId = Integer.parseInt(payload.get("boatId").toString());
            int slotId = Integer.parseInt(payload.get("slotId").toString());

            // ✅ Accept "date" or "bookingDate"
            String dateStr = payload.containsKey("date")
                    ? payload.get("date").toString()
                    : payload.get("bookingDate").toString();
            LocalDate date = LocalDate.parse(dateStr);

            int seats = Integer.parseInt(payload.get("seatCount").toString());

            boolean available = availabilityService.isPublicAvailable(boatId, date, slotId, seats);
            System.out.println("✅ Public availability: " + available);

            if (!available) {
                response.put("status", "failed");
                response.put("message", "Seats sold out after payment.");
                return ResponseEntity.badRequest().body(response);
            }

            String result = publicService.book(userId, boatId, slotId, date, seats);
            System.out.println("✅ publicService.book result: " + result);

            if (result.toLowerCase().contains("success")
                    || result.toLowerCase().contains("confirm")
                    || result.toLowerCase().contains("booked")) {
                response.put("status", "success");
                response.put("message", "Booking confirmed successfully!");
                return ResponseEntity.ok(response);
            } else {
                response.put("status", "failed");
                response.put("message", result);
                return ResponseEntity.badRequest().body(response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", "failed");
            response.put("message", "Error processing booking: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    /** ✅ Private Boat Booking */
    @PostMapping("/private/confirm")
    public ResponseEntity<?> confirmPrivateBooking(@RequestBody Map<String, Object> payload) {
        Map<String, Object> response = new HashMap<>();

        try {
            System.out.println("📥 Private Booking Payload: " + payload);

            long userId = Long.parseLong(payload.get("userId").toString());
            int boatId = Integer.parseInt(payload.get("boatId").toString());
            int slotId = Integer.parseInt(payload.get("slotId").toString());

            String dateStr = payload.containsKey("date")
                    ? payload.get("date").toString()
                    : payload.get("bookingDate").toString();
            LocalDate date = LocalDate.parse(dateStr);

            boolean available = availabilityService.isPrivateAvailable(boatId, date, slotId);
            System.out.println("✅ Private availability: " + available);

            if (!available) {
                response.put("status", "failed");
                response.put("message", "Slot already booked after payment.");
                return ResponseEntity.badRequest().body(response);
            }

            String result = privateService.book(userId, boatId, slotId, date);
            System.out.println("✅ privateService.book result: " + result);

            if (result.toLowerCase().contains("success")
                    || result.toLowerCase().contains("confirm")
                    || result.toLowerCase().contains("booked")) {
                response.put("status", "success");
                response.put("message", "Booking confirmed successfully!");
                return ResponseEntity.ok(response);
            } else {
                response.put("status", "failed");
                response.put("message", result);
                return ResponseEntity.badRequest().body(response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", "failed");
            response.put("message", "Error processing booking: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
