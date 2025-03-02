package com.HonnaBot.SagaraMitra.controller;

import com.HonnaBot.SagaraMitra.Entity.PrivateBoatBooking;
import com.HonnaBot.SagaraMitra.Service.PrivateBoatBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private-boat-booking")
public class PrivateBoatBookingController {

    @Autowired
    private PrivateBoatBookingService privateBoatBookingService;

    @PostMapping("/book")
    public PrivateBoatBooking bookPrivateBoat(@RequestBody PrivateBoatBooking booking) {
        return privateBoatBookingService.bookPrivateBoat(booking);
    }
}
