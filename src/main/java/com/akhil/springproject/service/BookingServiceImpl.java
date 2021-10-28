package com.akhil.springproject.service;

import com.akhil.springproject.dao.BookingRepository;
import com.akhil.springproject.dao.RestaurantRepository;
import com.akhil.springproject.dao.UserRepository;
import com.akhil.springproject.entity.Booking;
import com.akhil.springproject.entity.Restaurant;
import com.akhil.springproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private UserRepository userRepository;

    public int toInt(String s){
        return Integer.parseInt(s);
    }

    @Override
    public void save(Booking theBooking) {

        int rid = theBooking.getRestaurantId();

        int uid = theBooking.getUserId();

        Restaurant theRestaurant = restaurantRepository.getById(rid);
        User theUser = userRepository.getById(uid);

        theUser.add(theBooking);

        System.out.println("User Bookings : ");
        System.out.println(theUser.getBookings());

        theRestaurant.setAvailablePasses(String.valueOf(toInt(theRestaurant.getAvailablePasses())-theBooking.getNumberOfPasses()));

        restaurantRepository.save(theRestaurant);
        bookingRepository.save(theBooking);
    }
}
