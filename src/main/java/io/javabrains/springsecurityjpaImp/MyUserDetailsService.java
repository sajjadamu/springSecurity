package io.javabrains.springsecurityjpaImp;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	@Autowired
	HttpSession session;

	Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println("loadUserByUsername useName " + username); 
		
		Optional<User> user = userRepository.findByUsername(username);

		user.orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
		System.out.println("loadUserByUsername user..... " + user.toString());

		UserDetails userDetails = user.map(MyUserDetails::new).get();

		System.out.println("loadUserByUsername userDetails..... " + userDetails.toString());

		session.setAttribute("loginDetails", userDetails);

		return userDetails;
	}

}
