package com.akhil.springproject.service;

import com.akhil.springproject.dto.RestaurantDTO;
import com.akhil.springproject.entity.Restaurant;

import java.util.List;

public interface RestaurantService {

    public List<RestaurantDTO> findAll();

    public Restaurant findById(int theId);

    public void save(Restaurant theRestaurant);

    public void deleteById(int theId);

}
