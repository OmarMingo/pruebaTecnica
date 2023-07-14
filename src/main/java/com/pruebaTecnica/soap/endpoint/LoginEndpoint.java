package com.pruebaTecnica.soap.endpoint;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.pruebaTecnica.controller.LoginController;
import com.pruebaTecnica.entity.User;
import com.pruebaTecnica.service.LoginService;

@WebService(endpointInterface = "com.pruebaTecnica.prueba.LoginService", serviceName = "LoginService")
public class LoginEndpoint implements LoginService{

	@Autowired
	LoginController loginController;
	
	@Resource
	WebServiceContext wsContext;
	
	@Override
	public String getToken(User user) {
		return loginController.get(user);
	}

}
