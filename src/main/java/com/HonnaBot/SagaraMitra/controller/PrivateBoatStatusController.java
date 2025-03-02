package com.HonnaBot.SagaraMitra.controller;

import com.HonnaBot.SagaraMitra.Entity.PrivateBoatStatus;
import com.HonnaBot.SagaraMitra.Service.PrivateBoatStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/private-boat-status")
public class PrivateBoatStatusController {

    @Autowired
    private PrivateBoatStatusService privateBoatStatusService;

    @GetMapping("/{boatId}/{date}/{slotId}")
    public Optional<PrivateBoatStatus> getStatusByBoatAndSlot(
            @PathVariable int boatId, @PathVariable String date, @PathVariable int slotId) {
        return privateBoatStatusService.getStatusByBoatAndSlot(boatId, date, slotId);
    }
}