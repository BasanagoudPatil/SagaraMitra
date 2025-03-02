package com.HonnaBot.SagaraMitra.Service;

import com.HonnaBot.SagaraMitra.Entity.BoatOwner;
import com.HonnaBot.SagaraMitra.Repositories.BoatOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatOwnerService {
    @Autowired
    private BoatOwnerRepository boatOwnerRepository;

    public BoatOwner registerBoatOwner(BoatOwner owner) {
        return boatOwnerRepository.save(owner);
    }

    public List<BoatOwner> getAllBoatOwners() {
        return boatOwnerRepository.findAll();
    }
}
