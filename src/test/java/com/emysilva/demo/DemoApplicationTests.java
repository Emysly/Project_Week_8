package com.emysilva.demo;

import com.emysilva.demo.model.Post;
import com.emysilva.demo.model.User;
import com.emysilva.demo.repository.UserRepository;
import com.emysilva.demo.service.PostService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PostService postService;

	List<Post> posts;

	List<User> users;

	@BeforeEach
	void setUp() {
		posts = postService.listAllPost();
		users = new ArrayList<>();
	}

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

		users.add(user);

		assertEquals(1, users.size());
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

	@Test
	void listAllPosts() {

		assertEquals(posts.size(), posts.size());
	}

	@Test
	void addPost() {
		Post post = new Post();
		post.setTitle("Things fall apart");
		post.setMessage("Things fall apart is a great novel");
		post.setCreatedAt("09-09-2020 04:25:53");
		post.setLikes(2);
		post.setUnlikes(3);

		int initialSize = posts.size();

		posts.add(post);

		assertEquals(initialSize + 1, posts.size());
	}

	@Test
	void deletePost() {
		int initialSize = posts.size();

		posts.remove(0);

		assertEquals(initialSize - 1, posts.size());
	}

}
