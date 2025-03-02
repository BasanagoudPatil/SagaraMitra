package com.HonnaBot.SagaraMitra.controller;

import com.HonnaBot.SagaraMitra.Entity.PublicBoat;
import com.HonnaBot.SagaraMitra.Service.PublicBoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public-boats")
public class PublicBoatController {

    @Autowired
    private PublicBoatService publicBoatService;

    @PostMapping("/add")
    public PublicBoat addPublicBoat(@RequestBody PublicBoat boat) {
        return publicBoatService.addPublicBoat(boat);
    }

    @GetMapping("/location/{location}")
    public List<PublicBoat> getPublicBoatsByLocation(@PathVariable String location) {
        return publicBoatService.getPublicBoatsByLocation(location);
    }
}