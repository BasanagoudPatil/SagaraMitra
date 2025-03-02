package com.HonnaBot.SagaraMitra.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.lang.model.element.Name;
import javax.print.attribute.standard.MediaSize;

@Entity
@Table(name = "Public_Boats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicBoat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String boat_id;

    @Column(unique = true, nullable = false)
    private String boat_name;

    @Column(nullable = false)
    private int capacity = 7;

    @Column(nullable = false)
    private String pickup_drop_location;

    @ManyToOne
    @JoinColumn(name = "owner_id",nullable = false)
    private BoatOwner owner;

    public String getBoat_id() {
        return boat_id;
    }

    public void setBoat_id(String boat_id) {
        this.boat_id = boat_id;
    }

    public String getBoat_name() {
        return boat_name;
    }

    public void setBoat_name(String boat_name) {
        this.boat_name = boat_name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPickup_drop_location() {
        return pickup_drop_location;
    }

    public void setPickup_drop_location(String pickup_drop_location) {
        this.pickup_drop_location = pickup_drop_location;
    }

    public BoatOwner getOwner() {
        return owner;
    }

    public void setOwner(BoatOwner owner) {
        this.owner = owner;
    }
}
