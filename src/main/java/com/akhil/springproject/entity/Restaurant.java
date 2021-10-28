package com.akhil.springproject.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="restaurant_name")
    private String restaurantName;

    @Column(name = "rating")
    private String rating;

    @Column(name="email")
    private String email;

    @Column(name="phone_no")
    private String phoneNo;

    @Column(name="available_passes")
    private String availablePasses;

    @Column(name="total_passes")
    private String totalPasses;

    @Column(name="address")
    private String address;

    public Restaurant(){}

    public Restaurant(int id, String restaurantName, String rating, String email, String phoneNo, String availablePasses, String address) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.rating = rating;
        this.email = email;
        this.phoneNo = phoneNo;
        this.availablePasses = availablePasses;
        this.address = address;
    }

    public Restaurant(String restaurantName, String rating, String email, String phoneNo, String availablePasses, String address) {
        this.restaurantName = restaurantName;
        this.rating = rating;
        this.email = email;
        this.phoneNo = phoneNo;
        this.availablePasses = availablePasses;
        this.address = address;
    }
}
