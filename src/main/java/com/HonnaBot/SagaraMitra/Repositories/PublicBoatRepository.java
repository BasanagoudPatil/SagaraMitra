package com.HonnaBot.SagaraMitra.Repositories;

import com.HonnaBot.SagaraMitra.Entity.PublicBoat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicBoatRepository extends JpaRepository<PublicBoat, Integer> {

    @Query("SELECT DISTINCT b.pickupDropLocation FROM PublicBoat b")
    List<String> findDistinctPickupDropLocations();

    List<PublicBoat> findByPickupDropLocation(String location);}