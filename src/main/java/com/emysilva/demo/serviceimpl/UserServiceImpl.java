package com.emysilva.demo.serviceimpl;

import com.emysilva.demo.model.User;
import com.emysilva.demo.repository.UserRepository;
import com.emysilva.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


//@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public void signup(User user) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateTime = now.format(format);

		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setFirstname(user.getFirstname());
		newUser.setLastname(user.getLastname());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setConfPassword(user.getConfPassword());
		newUser.setCreatedAt(formatDateTime);
		newUser.setContact(user.getContact());

		userRepository.save(newUser);
	}

	@Override
	public Iterable<User> findUser() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findUserById(Long id) {
		return userRepository.findById(id);
	}


		public boolean loadUserByEmailAndPassword(String email, String password) throws UsernameNotFoundException {

			final Optional<User> optionalUser = userRepository.findByEmailAndPassword(email, password);

			return optionalUser.isPresent();
		}

}
