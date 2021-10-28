package com.akhil.springproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="booking_id")
    private int bookingId;

    @Column(name="user_id")
    private int userId;

    @Column(name="restaurant_id")
    private int restaurantId;

    @Column(name="number_of_passes")
    private int numberOfPasses;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    public Booking(){}

    public Booking(int userId, int restaurantId, int numberOfPasses) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.numberOfPasses = numberOfPasses;
    }

    public Booking(int numberOfPasses) {
        this.numberOfPasses = numberOfPasses;
    }
}
