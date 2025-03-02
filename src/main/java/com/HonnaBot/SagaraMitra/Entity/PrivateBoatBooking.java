package com.HonnaBot.SagaraMitra.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Private_Boat_Booking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrivateBoatBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booking_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "boat_id", nullable = false)
    private PrivateBoat boat;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date booking_date;

    @ManyToOne
    @JoinColumn(name = "slot_id", nullable = false)
    private PrivateBoatSlot slot;

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PrivateBoat getBoat() {
        return boat;
    }

    public void setBoat(PrivateBoat boat) {
        this.boat = boat;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public PrivateBoatSlot getSlot() {
        return slot;
    }

    public void setSlot(PrivateBoatSlot slot) {
        this.slot = slot;
    }
}
