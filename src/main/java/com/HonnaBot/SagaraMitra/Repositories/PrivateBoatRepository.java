package com.HonnaBot.SagaraMitra.Repositories;

import com.HonnaBot.SagaraMitra.Entity.PrivateBoat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrivateBoatRepository extends JpaRepository<PrivateBoat, Integer> {
    @Query("SELECT DISTINCT b.pickupDropLocation FROM PrivateBoat b")
    List<String> findDistinctPickupDropLocations();

    List<PrivateBoat> findByPickupDropLocation(String location);

}
