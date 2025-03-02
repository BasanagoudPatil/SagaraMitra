package com.HonnaBot.SagaraMitra.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Public_Boat_Booking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicBoatBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booking_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "boat_id", nullable = false)
    private PublicBoat boat;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date booking_date;

    @ManyToOne
    @JoinColumn(name = "slot_id", nullable = false)
    private PublicBoatSlot slot;

    @Column(nullable = false)
    private int seats_booked;

    public int getBooking_id() {
        return booking_id;
    }

    public User getUser() {
        return user;
    }

    public PublicBoat getBoat() {
        return boat;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public PublicBoatSlot getSlot() {
        return slot;
    }

    public int getSeats_booked() {
        return seats_booked;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBoat(PublicBoat boat) {
        this.boat = boat;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public void setSlot(PublicBoatSlot slot) {
        this.slot = slot;
    }

    public void setSeats_booked(int seats_booked) {
        this.seats_booked = seats_booked;
    }
}
