package com.team1.progettocarsharingteam1.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "scooters")
public class Scooter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private boolean isAvailable;

    @Column(nullable = false)
    private String details;

    @OneToMany
    private List<Rent> rentals;

    public Scooter() {
    }

    public Scooter(Integer id, String model, boolean isAvailable, String details) {
        this.id = id;
        this.model = model;
        this.isAvailable = isAvailable;
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Rent> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rent> rentals) {
        this.rentals = rentals;
    }
}
