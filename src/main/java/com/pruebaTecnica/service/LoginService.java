package com.pruebaTecnica.service;

import org.springframework.stereotype.Service;

import com.pruebaTecnica.entity.User;

@Service
public interface LoginService {

	public String getToken(User user);

}
