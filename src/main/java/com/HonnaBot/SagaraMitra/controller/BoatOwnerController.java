package com.HonnaBot.SagaraMitra.controller;

import com.HonnaBot.SagaraMitra.Entity.BoatOwner;
import com.HonnaBot.SagaraMitra.Service.BoatOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boat-owners")
public class BoatOwnerController {

    @Autowired
    private BoatOwnerService boatOwnerService;

    @PostMapping("/register")
    public BoatOwner registerBoatOwner(@RequestBody BoatOwner owner) {
        return boatOwnerService.registerBoatOwner(owner);
    }

    @GetMapping("/all")
    public List<BoatOwner> getAllBoatOwners() {
        return boatOwnerService.getAllBoatOwners();
    }
}
