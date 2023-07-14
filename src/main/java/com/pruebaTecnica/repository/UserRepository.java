package com.pruebaTecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebaTecnica.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	void updateUser(User user);

	void createUser(User user);

}
