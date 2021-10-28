package com.akhil.springproject.dto;

import lombok.Data;


@Data
public class RestaurantDTO {

    private int id;

    private String restaurantName;

    private String rating;

    private String email;

    private String phoneNo;

    private String availablePasses;

    private String totalPasses;

    private String address;

}
