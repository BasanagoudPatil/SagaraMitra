package com.HonnaBot.SagaraMitra.controller;

import com.HonnaBot.SagaraMitra.Service.AvailabilityService;
import com.HonnaBot.SagaraMitra.Service.RazorpayService;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private RazorpayService razorpayService;

    @Autowired
    private AvailabilityService availabilityService;

    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(
            @RequestParam int boatId,
            @RequestParam String bookingDate,
            @RequestParam int slotId,
            @RequestParam int seats,
            @RequestParam boolean isPrivate,
            @RequestParam int amount,
            @RequestParam String currency) {

        LocalDate date = LocalDate.parse(bookingDate);

        boolean available = isPrivate
                ? availabilityService.isPrivateAvailable(boatId, date, slotId)
                : availabilityService.isPublicAvailable(boatId, date, slotId, seats);

        if (!available) {
            return ResponseEntity.badRequest()
                    .body(new JSONObject().put("error", "Selected slot/seats no longer available").toString());
        }

        try {
            // ✅ Razorpay order created and returned as JSON
            String orderJson = razorpayService.createOrder(amount, currency, "receipt_" + boatId + "_" + slotId);
            return ResponseEntity.ok(orderJson);
        } catch (RazorpayException e) {
            return ResponseEntity.status(500)
                    .body(new JSONObject().put("error", "Payment gateway error: " + e.getMessage()).toString());
        }
    }
}
