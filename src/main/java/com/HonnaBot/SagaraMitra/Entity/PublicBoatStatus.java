package com.HonnaBot.SagaraMitra.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Public_Boat_Status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicBoatStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int status_id;

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
    private int available_seats;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BoatStatus boat_status;



    public enum BoatStatus {
        AVAILABLE, FULL
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public PublicBoat getBoat() {
        return boat;
    }

    public void setBoat(PublicBoat boat) {
        this.boat = boat;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public PublicBoatSlot getSlot() {
        return slot;
    }

    public void setSlot(PublicBoatSlot slot) {
        this.slot = slot;
    }

    public int getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(int available_seats) {
        this.available_seats = available_seats;
    }

    public BoatStatus getBoat_status() {
        return boat_status;
    }

    public void setBoat_status(BoatStatus boat_status) {
        this.boat_status = boat_status;
    }
}
