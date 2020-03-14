package io.javabrains.springsecurityjpaImp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	
	Logger log =  LoggerFactory.getLogger(SecurityConfiguration.class);

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		System.out.println(" AuthenticationManagerBuilder ........................."+auth.toString());
		auth.userDetailsService(userDetailsService);
		System.out.println(" AuthenticationManagerBuilder ........................."+auth.toString());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		System.out.println(" HttpSecurity ........................."+http.toString());
		 http.authorizeRequests()
		      .antMatchers("/admin").hasRole("ADMIN")
		      .antMatchers("/user").hasAnyRole("USER","ADMIN")
			  .antMatchers("/").permitAll().and().formLogin();
		System.out.println(" HttpSecurity ........................."+http.toString());
		
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		System.out.println(" PasswordEncoder .........................");
		//PasswordEncoder encoder = new BCryptPasswordEncoder();
		 return NoOpPasswordEncoder.getInstance();
		//return encoder;
	}
}
