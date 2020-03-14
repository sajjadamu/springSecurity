package io.javabrains.springsecurityjpaImp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
//@ComponentScan(basePackages = { "io.javabrains.springsecurityjpaImp.*" })
@EnableWebSecurity
@EntityScan(basePackages = "model")
public class SpringSecurityJpaImpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJpaImpApplication.class, args);
	}

}
