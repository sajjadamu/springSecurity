package io.javabrains.springsecurityjpaImp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EntityScan(basePackages = "model")
public class SpringSecurityJpaImpApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJpaImpApplication.class, args);

	}

}
