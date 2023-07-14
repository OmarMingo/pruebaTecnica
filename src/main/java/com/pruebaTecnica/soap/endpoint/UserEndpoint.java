package com.pruebaTecnica.soap.endpoint;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.pruebaTecnica.entity.User;
import com.pruebaTecnica.rest.controller.UserController;
import com.pruebaTecnica.service.UserService;

@WebService(endpointInterface = "com.pruebaTecnica.prueba.UserService", serviceName = "UserService")
public class UserEndpoint implements UserService{

	@Autowired
	UserController userController;
	
	@Resource
	WebServiceContext wsContext;
	
	
	@Override 
	public List<User> getListUser() {
		return userController.getListUser();
	}


	@Override
	public Optional<User> getUserById(Long id) {
		return userController.getUserById(id);
	}


	@Override
	public void updateUser(User user) {
		userController.updateUser(user);
	}


	@Override
	public void createUser(User user) {
		userController.createUser(user);
	}


	@Override
	public boolean deleteUser(User user) {
		return userController.deleteUser(user);
		
	}
}
