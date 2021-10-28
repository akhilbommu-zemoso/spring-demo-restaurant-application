package com.akhil.springproject.dto;

import com.akhil.springproject.entity.Booking;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class UserDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    @ToString.Exclude
    List<Booking> bookings;

    public UserDTO(){}

    public UserDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
