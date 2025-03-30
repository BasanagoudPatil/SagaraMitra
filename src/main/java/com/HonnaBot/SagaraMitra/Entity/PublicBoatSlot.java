package com.HonnaBot.SagaraMitra.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Public_Boat_Slots")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublicBoatSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slotId;

    @Column(nullable = false)
    private String slotTime;
}
