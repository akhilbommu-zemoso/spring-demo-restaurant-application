package com.akhil.springproject.controller;

import com.akhil.springproject.dto.RestaurantDTO;
import com.akhil.springproject.entity.Restaurant;
import com.akhil.springproject.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService theRestaurantService){
        restaurantService = theRestaurantService;
    }

    @GetMapping("/list")
    public String listRestaurants(Model theModel){
        List<RestaurantDTO> theRestaurants = restaurantService.findAll();

        theModel.addAttribute("restaurants", theRestaurants);

        return "restaurants/list-restaurants";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Restaurant theRestaurant = new Restaurant();

        theModel.addAttribute("restaurant", theRestaurant);

        return "restaurants/restaurant-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("restaurantId") int theId, Model theModel){
        Restaurant theRestaurant = restaurantService.findById(theId);

        theModel.addAttribute("restaurant", theRestaurant);

        return "restaurants/restaurant-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("restaurant") Restaurant theRestaurant){
        restaurantService.save(theRestaurant);

        return "redirect:/restaurants/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("restaurantId") int theId){
        restaurantService.deleteById(theId);

        return "redirect:/restaurants/list";
    }

    @GetMapping("/showLoginPage")
    public String showAdminLogin(){
        return "adminLogin";
    }

    @PostMapping("/logout")
    public String logout(){
        return "homepage";
    }

}
