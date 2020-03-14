package io.javabrains.springsecurityjpaImp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource implements ErrorController {

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
		return "<h1>welcome user</>";
	}

	@GetMapping("/admin")
	public String admin() {
		return "<h1>welcome admin</>";
	}
	
	
	@ExceptionHandler(Exception.class)
	public void handleException(Exception exception) {
		exception.printStackTrace();
	}

	@RequestMapping("/error")
    public String handleError() {
        return "error";
    }
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
