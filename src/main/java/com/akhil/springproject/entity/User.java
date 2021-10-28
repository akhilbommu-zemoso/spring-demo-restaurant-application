package com.akhil.springproject.entity;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @NotNull(message="Require Field")
    @Column(name="first_name")
    String firstName;

    @NotNull(message="Require Field")
    @Column(name="last_name")
    String lastName;

    @NotNull
    @Column(name="email")
    String email;

    @NotNull
    @Column(name="password")
    String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Booking> bookings;

    public User(){}

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public void add(Booking theBooking) {
        if(bookings == null){
            bookings = new ArrayList<>();
        }
        bookings.add(theBooking);
        theBooking.setUser(this);
    }
}
