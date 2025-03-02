package com.HonnaBot.SagaraMitra.controller;

import com.HonnaBot.SagaraMitra.Entity.PrivateBoat;
import com.HonnaBot.SagaraMitra.Service.PrivateBoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/private-boats")
public class PrivateBoatController {

    @Autowired
    private PrivateBoatService privateBoatService;

    @PostMapping("/add")
    public PrivateBoat addPrivateBoat(@RequestBody PrivateBoat boat) {
        return privateBoatService.addPrivateBoat(boat);
    }

    @GetMapping("/location/{location}")
    public List<PrivateBoat> getPrivateBoatsByLocation(@PathVariable String location) {
        return privateBoatService.getPrivateBoatsByLocation(location);
    }
}
