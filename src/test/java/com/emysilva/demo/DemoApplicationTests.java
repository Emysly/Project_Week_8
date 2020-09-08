package com.emysilva.demo;

import com.emysilva.demo.model.User;
import com.emysilva.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserRepository userRepository;


//	@Test
//	void contextLoads() {
//	}


	@Test
	void signup() {
		User user = new User();
		user.setEmail("user1@gmail.com");
		user.setFirstname("user");
		user.setLastname("1");
		user.setUsername("user1");
		user.setPassword("password1");
		user.setConfPassword("password1");
		user.setContact("09040201098");

		assertEquals(user, userRepository.save(user));
	}

	@Test
	void login() {
		User user = new User();
		user.setEmail("user1@gmail.com");
		user.setPassword("password1");

		String email = user.getEmail();
		String password = user.getPassword();
		Optional<User> optionalUser = userRepository.findByEmailAndPassword(email, password);

		assertTrue(optionalUser.isPresent());
	}

}
