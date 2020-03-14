package io.javabrains.springsecurityjpaImp;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController    /// for only data
@Controller        /// for jps page with data
public class Resource {

	@Autowired
	HttpSession httpSession;

	@GetMapping("/")
	public String home(Map<String, Object> model) {
		model.put("message", "You are in new page !!");
		System.out.println(" Resource loginDetails in home method " + httpSession.getAttribute("loginDetails"));
		return "index";
	}

	@GetMapping("/user")
	public String user() {
		System.out.println(" Resource loginDetails in user method " + httpSession.getAttribute("loginDetails"));
		return "hello";
	}

	@GetMapping("/admin")
	public String admin() {
		return "<h1>welcome admin</>";
	}
}
