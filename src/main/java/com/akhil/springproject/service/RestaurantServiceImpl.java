package com.akhil.springproject.service;

import com.akhil.springproject.converter.RestaurantConverter;
import com.akhil.springproject.dao.RestaurantRepository;
import com.akhil.springproject.dto.RestaurantDTO;
import com.akhil.springproject.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantConverter restaurantConverter;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository theRestaurantRepository){
        restaurantRepository = theRestaurantRepository;
    }

    @Override
    public List<RestaurantDTO> findAll() {
        return restaurantConverter.entityToDto(restaurantRepository.findAll());
    }

    @Override
    public Restaurant findById(int theId) {
        Optional<Restaurant> result = restaurantRepository.findById(theId);

        Restaurant theRestaurant = null;

        if(result.isPresent()){
            theRestaurant = result.get();
        }else{
            throw new RuntimeException("Did not find restaurant id - " + theId);
        }

        return theRestaurant;
    }

    @Override
    public void save(Restaurant restaurant) {
        restaurant.setAvailablePasses(restaurant.getTotalPasses());
        restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteById(int theId) {
        restaurantRepository.deleteById(theId);
    }

}
