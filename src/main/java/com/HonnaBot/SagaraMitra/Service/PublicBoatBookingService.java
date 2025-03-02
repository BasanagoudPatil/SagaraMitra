package com.HonnaBot.SagaraMitra.Service;

import com.HonnaBot.SagaraMitra.Entity.PublicBoatBooking;
import com.HonnaBot.SagaraMitra.Entity.PublicBoatStatus;
import com.HonnaBot.SagaraMitra.Repositories.PublicBoatBookingRepository;
import com.HonnaBot.SagaraMitra.Repositories.PublicBoatStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicBoatBookingService {

    @Autowired
    private PublicBoatBookingRepository publicBoatBookingRepository;

    @Autowired
    private PublicBoatStatusRepository publicBoatStatusRepository;

    public PublicBoatBooking bookPublicBoat(PublicBoatBooking booking) {
        return null;
    }
}
