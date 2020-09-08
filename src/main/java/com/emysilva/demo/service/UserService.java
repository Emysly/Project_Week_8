package com.emysilva.demo.service;

import com.emysilva.demo.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserService {
	void signup(User user);
	Iterable<User> findUser ();
	Optional<User> findUserById(Long id);
	boolean loadUserByEmailAndPassword(String email, String password) throws UsernameNotFoundException;
}
