package io.javabrains.springsecurityjpaImp;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

@Component
public class Myfilter implements Filter {

	@Override
	public void destroy() {
		System.out.println(" doFilter destroy ");
		Filter.super.destroy();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println(" Filter init FilterConfig " + filterConfig.toString());
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println(" doFilter ServletRequest " + request.toString());
		System.out.println(" doFilter FilterChain " + filterChain.toString());
		filterChain.doFilter(request, response);
	}

}
