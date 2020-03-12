package io.javabrains.springsecurityjpaImp;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUseName(String useName);

}
