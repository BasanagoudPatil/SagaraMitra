package com.HonnaBot.SagaraMitra.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Public_Boat_Booking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublicBoatBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "boat_id", nullable = false)
    private PublicBoat boat;

    @ManyToOne
    @JoinColumn(name = "slot_id", nullable = false)
    private PublicBoatSlot slot;

    @Column(nullable = false)
    private LocalDate bookingDate;

    @Column(nullable = false)
    private int seatsBooked;
}
