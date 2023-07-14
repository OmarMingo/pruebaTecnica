package com.pruebaTecnica.service;

import java.util.List;
import java.util.Optional;

import com.pruebaTecnica.entity.User;

public interface UserService {

	List<User> getListUser();
	
	Optional<User> getUserById(Long id);
	
	void updateUser(User user);
	
	void createUser(User user);
	
	boolean deleteUser(User user);
}
