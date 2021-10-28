package com.akhil.springproject.helper;

public class Bookings {

    private String restaurantName;
    private int passes;

    public Bookings(String restaurantName, int passes) {
        this.restaurantName = restaurantName;
        this.passes = passes;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getPasses() {
        return passes;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }
}
