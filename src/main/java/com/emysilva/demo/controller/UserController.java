package com.emysilva.demo.controller;

import com.emysilva.demo.exception.SpringFacebookException;
import com.emysilva.demo.model.User;
import com.emysilva.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("users", userService.findUser());

		return "index";
	}

	@GetMapping("/signup")
	public String signup(User user, Model model) {
		model.addAttribute("user", user);
		return "signup";
	}

	@GetMapping("/login")
	public String login(User user, Model model) {
		model.addAttribute("user", user);
		return "login";
	}

	@PostMapping("/add-user")
	public String signup(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "signup";
		}
		userService.signup(user);
		return "login";
	}


	@PostMapping("/login-user")
	public String login(@Valid User user, BindingResult result) {
		if (userService.loadUserByEmailAndPassword(user.getEmail(), user.getPassword())) {
			userService.loadUserByEmailAndPassword(user.getEmail(), user.getPassword());
			return "dashboard";
		}
			return "login";
	}
}
