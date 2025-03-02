package com.HonnaBot.SagaraMitra.controller;

import com.HonnaBot.SagaraMitra.Entity.PublicBoatStatus;
import com.HonnaBot.SagaraMitra.Service.PublicBoatStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/public-boat-status")
public class PublicBoatStatusController {

    @Autowired
    private PublicBoatStatusService publicBoatStatusService;

    @GetMapping("/{boatId}/{date}/{slotId}")
    public Optional<PublicBoatStatus> getStatusByBoatAndSlot(
            @PathVariable int boatId, @PathVariable String date, @PathVariable int slotId) {
        return publicBoatStatusService.getStatusByBoatAndSlot(boatId, date, slotId);
    }
}