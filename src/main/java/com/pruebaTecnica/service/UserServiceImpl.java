package com.pruebaTecnica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaTecnica.entity.User;
import com.pruebaTecnica.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getListUser() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public void updateUser(User user) {
		userRepository.updateUser(user);
	}

	@Override
	public void createUser(User user) {
		userRepository.createUser(user);		
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			userRepository.delete(user);
			return true;
		}catch(Exception e){
			return false;
		}
	}

}
