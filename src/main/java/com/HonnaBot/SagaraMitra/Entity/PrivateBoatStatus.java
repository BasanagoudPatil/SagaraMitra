package com.HonnaBot.SagaraMitra.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Private_Boat_Status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrivateBoatStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int status_id;

    @ManyToOne
    @JoinColumn(name = "boat_id", nullable = false)
    private PrivateBoat boat;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date booking_date;

    @ManyToOne
    @JoinColumn(name = "slot_id", nullable = false)
    private PrivateBoatSlot slot;

    @Column(nullable = false)
    private boolean is_available = true;

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
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

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }
}
