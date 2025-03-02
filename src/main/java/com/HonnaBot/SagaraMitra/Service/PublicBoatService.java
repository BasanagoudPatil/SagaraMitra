package com.HonnaBot.SagaraMitra.Service;

import com.HonnaBot.SagaraMitra.Entity.PublicBoat;
import com.HonnaBot.SagaraMitra.Repositories.PublicBoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicBoatService {

    @Autowired
    private PublicBoatRepository publicBoatRepository;

    public PublicBoat addPublicBoat(PublicBoat boat) {
        return publicBoatRepository.save(boat);
    }

    public List<PublicBoat> getPublicBoatsByLocation(String location) {
        return publicBoatRepository.findByPickupDropLocation(location);
    }
}