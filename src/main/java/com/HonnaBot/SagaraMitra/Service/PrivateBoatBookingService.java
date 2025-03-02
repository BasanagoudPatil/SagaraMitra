package com.HonnaBot.SagaraMitra.Service;

import com.HonnaBot.SagaraMitra.Entity.PrivateBoatBooking;
import com.HonnaBot.SagaraMitra.Entity.PrivateBoatStatus;
import com.HonnaBot.SagaraMitra.Repositories.PrivateBoatBookingRepository;
import com.HonnaBot.SagaraMitra.Repositories.PrivateBoatStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivateBoatBookingService {

    @Autowired
    private PrivateBoatBookingRepository privateBoatBookingRepository;

    @Autowired
    private PrivateBoatStatusRepository privateBoatStatusRepository;


    public PrivateBoatBooking bookPrivateBoat(PrivateBoatBooking booking) {
        // Check boat availability
        return null;
    }
}