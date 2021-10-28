package com.akhil.springproject.controller;


import com.akhil.springproject.dto.RestaurantDTO;
import com.akhil.springproject.dto.UserDTO;
import com.akhil.springproject.entity.Booking;
import com.akhil.springproject.entity.Restaurant;
import com.akhil.springproject.entity.User;
import com.akhil.springproject.helper.Bookings;
import com.akhil.springproject.service.BookingService;
import com.akhil.springproject.service.RestaurantService;
import com.akhil.springproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {



    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/home")
    public String homepage(){
        return "userHome";
    }

    @GetMapping("/signup-form")
    public String showSignUpForm(){
        return "signupForm";
    }

    @GetMapping("/signin-form")
    public String showSigninForm(){
        return "signinForm";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User theUser){
        userService.save(theUser);
        return "redirect:/user/signin-form";
    }

    @PostMapping("/home")
    public String showUserPage(@RequestParam(name = "email")String email, @RequestParam(name = "password")String password, Model model){
        UserDTO user = userService.validate(email, password);
        if(user != null){
            List<RestaurantDTO> restaurants = restaurantService.findAll();
            model.addAttribute("user",user);
            model.addAttribute("restaurants", restaurants);
            return "userHome";
        }
        return "invalidPage";
    }

    @GetMapping("/logout")
    public String logout(){
        return "signupForm";
    }

    @GetMapping("/bookpasses")
    public String bookPasses(@RequestParam("rid") int rid, @RequestParam("uid") int uid, Model model){
        Restaurant restaurant = restaurantService.findById(rid);
        model.addAttribute("restaurant",restaurant);
        model.addAttribute("user", userService.findById(uid).get());
        String passes = restaurant.getAvailablePasses();
        return "bookPasses";
    }

    @PostMapping("/booked")
    public String booked(@RequestParam("rid") int rid, @RequestParam("uid") int uid,@RequestParam("numberOfPasses") int numberOfPasses,Model model){
        Booking booking = new Booking(uid,rid, numberOfPasses);

        model.addAttribute("user", userService.findById(uid).get());
        bookService.save(booking);

        // restaurantService.updatePasses(rid,numberOfPasses);

        List<RestaurantDTO> restaurants = restaurantService.findAll();

        model.addAttribute("restaurants", restaurants);

        System.out.println(booking);

        return "userHome";
    }

    @GetMapping("/mybookings")
    public String myBookings(@RequestParam("uid") int uid, Model model){
        List<Bookings> bookings = new ArrayList<>();

        for (Booking i:userService.findById(uid).get().getBookings()) {
            bookings.add(new Bookings(restaurantService.findById(i.getRestaurantId()).getRestaurantName(),i.getNumberOfPasses()));
        }

        model.addAttribute("restaurants", bookings);
        model.addAttribute("userid",uid);

        return "myBookings";
    }

    @GetMapping("/userpage")
    public String showUserPage(@RequestParam("uid") int uid, Model model){
        List<RestaurantDTO> restaurants = restaurantService.findAll();
        model.addAttribute("user",userService.findById(uid).get());
        model.addAttribute("restaurants", restaurants);
        return "userHome";
    }
}

