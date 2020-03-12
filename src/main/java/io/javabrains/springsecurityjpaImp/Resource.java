package io.javabrains.springsecurityjpaImp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {

	@GetMapping("/")
	public String home() {
		return "<h1>welcome</>";
	}

	@GetMapping("/user")
	public String user() {
		return "<h1>welcome user</>";
	}

	@GetMapping("/admin")
	public String admin() {
		return "<h1>welcome admin</>";
	}
}
