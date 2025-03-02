package com.HonnaBot.SagaraMitra.Service;

import com.HonnaBot.SagaraMitra.Entity.PrivateBoat;
import com.HonnaBot.SagaraMitra.Repositories.PrivateBoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivateBoatService {

    @Autowired
    private PrivateBoatRepository privateBoatRepository;

    public PrivateBoat addPrivateBoat(PrivateBoat boat) {
        return privateBoatRepository.save(boat);
    }

    public List<PrivateBoat> getPrivateBoatsByLocation(String location) {
        return privateBoatRepository.findByPickupDropLocation(location);
    }
}