package com.HonnaBot.SagaraMitra.Repositories;

import com.HonnaBot.SagaraMitra.Entity.PublicBoat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicBoatRepository extends JpaRepository<PublicBoat, Integer> {
    List<PublicBoat> findByPickupDropLocation(String location);
}
