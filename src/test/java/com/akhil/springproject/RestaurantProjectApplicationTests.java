package com.akhil.springproject;

import com.akhil.springproject.dao.RestaurantRepository;
import com.akhil.springproject.dao.UserRepository;
import com.akhil.springproject.entity.Restaurant;
import com.akhil.springproject.entity.User;
import com.akhil.springproject.service.RestaurantService;
import com.akhil.springproject.service.RestaurantServiceImpl;
import com.akhil.springproject.service.UserService;
import com.akhil.springproject.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RestaurantProjectApplication.class})
class RestaurantProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RestaurantService restaurantService;

	@Mock
	private RestaurantRepository mockRestaurantRepository;

	@Autowired
	private UserService userService;

	@Mock
	private UserRepository mockUserRepository;

	@BeforeEach
	void initUseCase(){
		restaurantService = new RestaurantServiceImpl(mockRestaurantRepository);
		userService = new UserServiceImpl(mockUserRepository);
	}

	@Test
	void findByIdMocked(){
		Restaurant restaurant = new Restaurant("Bawarchi","4.5","bawarchi@gmail.com","9666980838","100","RTC X-Roads");
		Mockito.when(mockRestaurantRepository.findById(1)).thenReturn(java.util.Optional.of(restaurant));
		Assert.assertEquals(restaurant, restaurantService.findById(1));
		Mockito.verify(mockRestaurantRepository).findById(1);
	}

	@Test
	void saveUser(){
		User user = new User("Akhil","Bommu","akhil@gmail.com","test1234");
		Mockito.when(mockUserRepository.save(user)).thenReturn(user);
		User theUser = userService.save(user);
		assertThat(theUser.getFirstName()).isNotNull();
	}
}
