package com.akhil.springproject.converter;

import com.akhil.springproject.dto.RestaurantDTO;
import com.akhil.springproject.entity.Restaurant;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantConverter {
    public RestaurantDTO entityToDto(Restaurant theRestaurant){
        ModelMapper mapper = new ModelMapper();
        RestaurantDTO map = mapper.map(theRestaurant,RestaurantDTO.class);
        return map;
    }

    public Restaurant dtoToEntity(RestaurantDTO theRestaurantDTO){
        ModelMapper mapper = new ModelMapper();
        Restaurant map = mapper.map(theRestaurantDTO, Restaurant.class);
        return map;
    }

    public List<RestaurantDTO> entityToDto(List<Restaurant> restaurants)
    {
        return restaurants.stream().map(x->entityToDto(x)).collect(Collectors.toList());
    }

    public List<Restaurant> dtoToEntity(List<RestaurantDTO> restaurantDtos)
    {
        return restaurantDtos.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
    }
}
