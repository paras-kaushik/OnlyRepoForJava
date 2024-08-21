package com.investment.e_commerce;

import com.investment.e_commerce.dao.OrderRepository;
import com.investment.e_commerce.dao.UserRepository;
import com.investment.e_commerce.model.UserOrder;
import com.investment.e_commerce.model.User;
import com.investment.e_commerce.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		User newUser=createUserWithNoOrders();
	}

	User createUserWithNoOrders() {
		String email = "john.doe@example.com";
		User tempUser=userExistsByEmail(email);
		if (tempUser!=null) {
			System.out.println("User with email " + email + " already exists.");
			return tempUser;
		}

		User user = new User(
				"John",
				"Doe",
				LocalDate.of(1990, 1, 1),
				"New York",
				"password123",
				email,
				UserRole.CUSTOMER,
				null,
				Arrays.asList("Reading", "Hiking"),
				new HashMap<>(Map.of("Home", "123 Main St", "Work", "456 Business Ave"))
		);

		// Save User to the database
		userRepository.save(user);
		System.out.println("User created: " + user.getFirstName() + " " + user.getLastName());
		return user;
	}




	User userExistsByEmail(String email) {
		return userRepository.findByEmail(email).isPresent() ? userRepository.findByEmail(email).get():null;
	}




}
