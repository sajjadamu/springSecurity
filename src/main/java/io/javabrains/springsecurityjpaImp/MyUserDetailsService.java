package io.javabrains.springsecurityjpaImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import model.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println("loadUserByUsername useName " + username); 
		
		Optional<User> user = userRepository.findByUsername(username);

		System.out.println("loadUserByUsername user " + user);

		user.orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

		return user.map(MyUserDetails::new).get();
	}

}
