package com.HonnaBot.SagaraMitra.Repositories;

import com.HonnaBot.SagaraMitra.Entity.PrivateBoat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrivateBoatRepository extends JpaRepository<PrivateBoat, Integer> {
    List<PrivateBoat> findByPickupDropLocation(String location);
}
