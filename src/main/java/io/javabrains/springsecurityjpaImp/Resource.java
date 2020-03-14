package io.javabrains.springsecurityjpaImp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource /*implements ErrorController*/ {

	@CrossOrigin("http://example.com")
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
	
	
	@ExceptionHandler(Exception.class)
	public void handleException(Exception exception) {
		exception.printStackTrace();
	}

	/*@RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        return "error";
    }
 
    @Override
    public String getErrorPath() {
        return "/error";
    }*/
}
