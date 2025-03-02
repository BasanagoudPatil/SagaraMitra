package com.HonnaBot.SagaraMitra.Service;

import com.HonnaBot.SagaraMitra.Entity.PrivateBoatStatus;
import com.HonnaBot.SagaraMitra.Repositories.PrivateBoatStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrivateBoatStatusService {

    @Autowired
    private PrivateBoatStatusRepository privateBoatStatusRepository;

    public Optional<PrivateBoatStatus> getStatusByBoatAndSlot(int boatId, String date, int slotId) {
        return privateBoatStatusRepository.findByBoatIdAndBookingDateAndSlotId(boatId, date, slotId);
    }
}
