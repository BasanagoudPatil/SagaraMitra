package com.HonnaBot.SagaraMitra.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Public_Boat_Slots")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicBoatSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sloat_id;

    @Column(nullable = false)
    private String sloat_time;

    public int getSloat_id() {
        return sloat_id;
    }

    public void setSloat_id(int sloat_id) {
        this.sloat_id = sloat_id;
    }

    public String getSloat_time() {
        return sloat_time;
    }

    public void setSloat_time(String sloat_time) {
        this.sloat_time = sloat_time;
    }
}
