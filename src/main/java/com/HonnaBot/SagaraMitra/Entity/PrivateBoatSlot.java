package com.HonnaBot.SagaraMitra.Entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "Private_Boat_Slots")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrivateBoatSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slot_id;

    @Column(nullable = false)
    private String slot_time;

    public int getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    public String getSlot_time() {
        return slot_time;
    }

    public void setSlot_time(String slot_time) {
        this.slot_time = slot_time;
    }
}
