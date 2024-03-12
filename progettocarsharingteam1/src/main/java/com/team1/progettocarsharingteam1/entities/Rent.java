package com.team1.progettocarsharingteam1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "rentals")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime startTme;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /* @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "veicolo_id", nullable = false)
     private Veicolo veicolo;
     */

    @OneToOne(mappedBy = "rentals")
    private List<Review> reviewList;

    public Rent(Long id, LocalDate date, LocalTime startTme, LocalTime endTime, Double price) {
        this.id = id;
        this.date = date;
        this.startTme = startTme;
        this.endTime = endTime;
        this.price = price;
    }

    public Rent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTme() {
        return startTme;
    }

    public void setStartTme(LocalTime startTme) {
        this.startTme = startTme;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
