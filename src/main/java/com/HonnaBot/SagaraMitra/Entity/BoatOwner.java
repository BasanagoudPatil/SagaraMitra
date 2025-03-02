package com.HonnaBot.SagaraMitra.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "boat_owners")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoatOwner {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int owner_id;

  @Column(nullable = false)
    private String owner_name;

  @Column(nullable = false)
    private String owner_phone;

  public int getOwner_id() {
    return owner_id;
  }

  public void setOwner_id(int owner_id) {
    this.owner_id = owner_id;
  }

  public String getOwner_name() {
    return owner_name;
  }

  public void setOwner_name(String owner_name) {
    this.owner_name = owner_name;
  }

  public String getOwner_phone() {
    return owner_phone;
  }

  public void setOwner_phone(String owner_phone) {
    this.owner_phone = owner_phone;
  }
}
