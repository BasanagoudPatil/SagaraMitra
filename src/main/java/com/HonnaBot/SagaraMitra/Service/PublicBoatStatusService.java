package com.HonnaBot.SagaraMitra.Service;

import com.HonnaBot.SagaraMitra.Entity.PublicBoatStatus;
import com.HonnaBot.SagaraMitra.Repositories.PublicBoatStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublicBoatStatusService {

    @Autowired
    private PublicBoatStatusRepository publicBoatStatusRepository;

    public Optional<PublicBoatStatus> getStatusByBoatAndSlot(int boatId, String date, int slotId) {
        return publicBoatStatusRepository.findByBoatIdAndBookingDateAndSlotId(boatId, date, slotId);
    }
}
