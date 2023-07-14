package com.pruebaTecnica.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaTecnica.entity.User;
import com.pruebaTecnica.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/all")
	public List<User> getListUser() {
		return userService.getListUser();
	}

	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PutMapping("/update")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}

	@PostMapping("/create")
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}

	@DeleteMapping("/delete")
	public boolean deleteUser(@RequestBody User user) {
		return userService.deleteUser(user);
	}

}
