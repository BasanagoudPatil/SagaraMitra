package com.HonnaBot.SagaraMitra.controller;

import com.HonnaBot.SagaraMitra.Entity.PublicBoatBooking;
import com.HonnaBot.SagaraMitra.Service.PublicBoatBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public-boat-booking")
public class PublicBoatBookingController {

    @Autowired
    private PublicBoatBookingService publicBoatBookingService;

    @PostMapping("/book")
    public PublicBoatBooking bookPublicBoat(@RequestBody PublicBoatBooking booking) {
        return publicBoatBookingService.bookPublicBoat(booking);
    }
}
